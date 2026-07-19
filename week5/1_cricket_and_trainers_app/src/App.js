import React from 'react';
import { BrowserRouter, Routes, Route, Link, useParams } from 'react-router-dom';

function ListofPlayers() {
  const players = [
    { name: "Jack", score: 50 }, { name: "Michael", score: 70 },
    { name: "John", score: 40 }, { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 }, { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 }, { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 }, { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];
  const playersLessThan70 = players.filter(player => player.score <= 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((item, index) => (
          <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
        ))}
      </ul>
      <hr />
      <h2>List of Players having Scores Less than 70</h2>
      <ul>
        {playersLessThan70.map((item, index) => (
          <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
        ))}
      </ul>
    </div>
  );
}

function IndianPlayers({ team }) {
  const [first, , third, , fifth] = team;
  const [, second, , fourth, , sixth] = team;
  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </ul>
      <hr />
      <h2>Even Players</h2>
      <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </ul>
    </div>
  );
}

const trainersMock = [
  { id: 't-syed8', name: 'Syed Khaleelullah', email: 'khaleelullah@cognizant.com', phone: '9767651696', tech: '.NET', skills: ['C#', 'SQL Server', 'React', '.NET Core'] },
  { id: 't-jojo', name: 'Jojo Jose', email: 'jojo@cognizant.com', phone: '9897199231', tech: 'Java', skills: ['Java', 'JSP', 'Angular', 'Spring'] },
  { id: 't-elisa', name: 'Elisa Jones', email: 'elisa@cognizant.com', phone: '9871212235', tech: 'Python', skills: ['Python', 'Django', 'Angular'] }
];

function Home() {
  return <h3>Welcome to My Academy trainers page</h3>;
}

function TrainersList() {
  return (
    <div>
      <h3>Trainers List</h3>
      <ul>
        {trainersMock.map(trainer => (
          <li key={trainer.id} style={{ margin: '8px 0' }}>
            <Link to={`/trainers/${trainer.id}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainersMock.find(t => t.id === id);
  if (!trainer) return <h3>Trainer Not Found</h3>;
  return (
    <div style={{ marginTop: '20px' }}>
      <h3>Trainers Details</h3>
      <h4>{trainer.name} ({trainer.tech})</h4>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => <li key={index}>{skill}</li>)}
      </ul>
    </div>
  );
}

export default function App() {
  const flag = true; 
  const T20Players = ['Sachin1', 'Dhoni2', 'Virat3'];
  const RanjiTrophyPlayers = ['Rohit4', 'Yuvraj5', 'Raina6'];
  const mergedIndianTeam = [...T20Players, ...RanjiTrophyPlayers];

  if (flag) {
    return (
      <BrowserRouter>
        <div style={{ padding: '20px' }}>
          <h1>My Academy Trainers App</h1>
          <nav>
            <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
          </nav>
          <hr />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/trainers" element={<TrainersList />} />
            <Route path="/trainers/:id" element={<TrainerDetail />} />
          </Routes>
          <hr style={{ marginTop: '40px' }} />
          <ListofPlayers />
        </div>
      </BrowserRouter>
    );
  } else {
    return (
      <div style={{ padding: '20px' }}>
        <IndianPlayers team={mergedIndianTeam} />
        <hr />
        <h2>List of Indian Players Merged:</h2>
        <ul>
          {mergedIndianTeam.map((player, idx) => <li key={idx}>Mr. {player}</li>)}
        </ul>
      </div>
    );
  }
}