import React, { useState } from 'react';

export default function CountPeople() {
  const [entryCount, setEntryCount] = useState(0);
  const [exitCount, setExitCount] = useState(0);
  return (
    <div style={{ display: 'flex', gap: '40px', margin: '20px 0' }}>
      <div>
        <button onClick={() => setEntryCount(p => p + 1)} style={{ backgroundColor: '#90ee90' }}>Login</button>
        <span> {entryCount} People Entered!!!</span>
      </div>
      <div>
        <button onClick={() => setExitCount(p => p + 1)} style={{ backgroundColor: '#ff9999' }}>Exit</button>
        <span> {exitCount} People Left!!!</span>
      </div>
    </div>
  );
}