import React, { useState } from 'react';
import './App.css';
import BlogDetails from './BlogDetails';
import BookMarkDetails from './BookMarkDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [view, setView] = useState('blogs');

  const blogs = [
    { id: 1, title: 'React Hooks Explained', author: 'Dan Abramov', content: 'Hooks allow functional components to use state...', isBookmarked: true },
    { id: 2, title: 'Understanding Redux Toolkit', author: 'Mark Erikson', content: 'Redux Toolkit simplifies state management...', isBookmarked: false },
    { id: 3, title: 'Mastering JavaScript Async/Await', author: 'Kyle Simpson', content: 'Async functions make asynchronous code easier...', isBookmarked: true }
  ];

  const courses = [
    { id: 101, name: 'Full Stack React Development', duration: '6 Weeks', instructor: 'TechieSyed' },
    { id: 102, name: 'Modern Microservices with Spring Boot', duration: '8 Weeks', instructor: 'John Doe' }
  ];

  return (
    <div className="App" style={{ textAlign: 'center', marginTop: '30px' }}>
      <h1>Blogger Portal</h1>
      <div style={{ marginBottom: '20px' }}>
        <button onClick={() => setView('blogs')} style={{ margin: '0 5px', padding: '8px 16px' }}>All Blogs</button>
        <button onClick={() => setView('bookmarks')} style={{ margin: '0 5px', padding: '8px 16px' }}>Bookmarked Blogs</button>
        <button onClick={() => setView('courses')} style={{ margin: '0 5px', padding: '8px 16px' }}>Course Details</button>
      </div>

      <hr style={{ width: '80%' }} />

      {view === 'blogs' && <BlogDetails blogs={blogs} />}
      {view === 'bookmarks' && <BookMarkDetails blogs={blogs} />}
      {view === 'courses' && <CourseDetails courses={courses} />}
    </div>
  );
}

export default App;