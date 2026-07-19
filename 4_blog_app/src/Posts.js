import React from 'react';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(err => {
        throw new Error("Failed to fetch posts visually.");
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert(`An error occurred in the component: ${error.message}`);
    this.setState({ error: error.message });
  }

  render() {
    if (this.state.error) {
      return <h3 style={{ color: 'red' }}>Error loading data.</h3>;
    }
    return (
      <div style={{ padding: '20px' }}>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ marginBottom: '20px', borderBottom: '1px solid #eee' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}
export default Posts;