import React from 'react';

const BookMarkDetails = ({ blogs }) => {
  const bookmarked = blogs.filter((b) => b.isBookmarked);

  return (
    <div style={{ margin: '20px auto', width: '80%', textAlign: 'left' }}>
      <h2>Bookmarked Blogs</h2>
      {bookmarked.length === 0 ? (
        <p>No bookmarked blogs available.</p>
      ) : (
        bookmarked.map((blog) => (
          <div key={blog.id} style={{ borderBottom: '1px solid #ddd', padding: '10px 0' }}>
            <h3>{blog.title}</h3>
            <p><strong>Author:</strong> {blog.author}</p>
          </div>
        ))
      )}
    </div>
  );
};

export default BookMarkDetails;