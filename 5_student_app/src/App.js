import React from 'react';
import { Home } from './Components/Home';
import { About } from './Components/About';
import { Contact } from './Components/Contact';

export default function App() {
  return (
    <div className="container" style={{ padding: '40px', textAlign: 'center' }}>
      <Home />
      <About />
      <Contact />
    </div>
  );
}