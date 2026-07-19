import React from 'react';
import CountPeople from './CountPeople';
import CohortDetails from './CohortDetails';

function Cart({ item }) {
  return (
    <table border="1" cellPadding="10" style={{ borderColor: '#ccc', margin: '20px 0' }}>
      <thead>
        <tr style={{ color: 'green' }}><th>Name</th><th>Price</th></tr>
      </thead>
      <tbody>
        {item.map((p, i) => (
          <tr key={i} style={{ color: 'green' }}><td>{p.itemname}</td><td>{p.price}</td></tr>
        ))}
      </tbody>
    </table>
  );
}

export default function App() {
  const items = [
    { itemname: "Laptop", price: 80000 }, { itemname: "TV", price: 120000 },
    { itemname: "Washing Machine", price: 50000 }, { itemname: "Mobile", price: 30000 }
  ];

  const ongoingCohort = { code: "ADM21JF014", name: "Java FSD", startDate: "10-Sep-2021", status: "ongoing", coach: "Apoorv", trainer: "Elisa Smith" };

  return (
    <div style={{ padding: '20px' }}>
      <h1>Counter App (Lab 2)</h1>
      <CountPeople />
      <hr />
      <h1>Shopping Items (Lab 3)</h1>
      <Cart item={items} />
      <hr />
      <h1>Cohorts Details CSS Isolation (Lab 5)</h1>
      <CohortDetails cohort={ongoingCohort} />
    </div>
  );
}