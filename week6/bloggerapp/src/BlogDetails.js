import React from 'react';

const BlogDetails = ({ blogs }) => {
  return (
    <div style={{ margin: '20px auto', width: '80%', textAlign: 'left' }}>
      <h2>All Blogs</h2>
      {blogs.map((blog) => (
        <div key={blog.id} style={{ borderBottom: '1px solid #ddd', padding: '10px 0' }}>
          <h3>{blog.title}</h3>
          <p><strong>Author:</strong> {blog.author}</p>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;
