import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  // 'useState' is a React "hook" to hold our component's data
  // 'entryText' will hold the text from the text area
  // 'setEntryText' is the function we use to update it
  const [entryText, setEntryText] = useState('');

  // This function will be called when the "Save" button is clicked
  const handleSave = async () => {
    if (!entryText.trim()) {
      alert('Cannot save an empty entry!');
      return;
    }

    try {
      // This is the API call!
      // We're sending a POST request to our Java backend
      // with the entryText in the request body.
      const response = await axios.post('http://localhost:8080/api/entries', {
        entryText: entryText
      });

      // If the save is successful:
      console.log('Entry saved!', response.data);
      alert('Entry saved successfully with ID: ' + response.data.id);
      setEntryText(''); // Clear the text area

    } catch (error) {
      // If the save fails:
      console.error('There was an error saving the entry!', error);
      alert('Error saving entry. See console for details.');
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Aura Journal</h1>
        <textarea
          rows="10"
          cols="50"
          value={entryText}
          onChange={(e) => setEntryText(e.target.value)}
          placeholder="What's on your mind?"
        />
        <br />
        <button onClick={handleSave}>Save Entry</button>
      </header>
    </div>
  );
}

export default App;