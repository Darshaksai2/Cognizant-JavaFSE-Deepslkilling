import React, { useState } from 'react';

const CourseDetails = ({ courses }) => {
  const [showAuthor, setShowAuthor] = useState(false);

  return (
    <div style={{ margin: '20px auto', width: '80%', textAlign: 'left' }}>
      <h2>Course Details</h2>
      <button 
        onClick={() => setShowAuthor(!showAuthor)} 
        style={{ marginBottom: '15px', padding: '6px 12px' }}
      >
        {showAuthor ? 'Hide Author Details' : 'Show Author Details'}
      </button>

      {courses.map((course) => (
        <div key={course.id} style={{ border: '1px solid #ccc', padding: '15px', marginBottom: '10px' }}>
          <h3>{course.name}</h3>
          <p><strong>Duration:</strong> {course.duration}</p>
          {showAuthor && <p><strong>Instructor:</strong> {course.instructor}</p>}
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;