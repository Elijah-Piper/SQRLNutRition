import logo from './logo.svg';
import Table from './Comp/Table.js';
import Home from './Comp/Home.js';
import Navbar from './Comp/Navbar.js';
import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

function App() {
  return (
    <Router>
      <Navbar />
    <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
    </div>
    </Router>
  );
}

export default App;
