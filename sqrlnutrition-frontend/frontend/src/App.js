import Table from './Comp/Table.js';
import Home from './Comp/Home.js';
import Login from './Comp/Login.js';
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
          <Route path="/login" element={<Login />} />
          <Route path="/sqrls" element={<Table />} />
        </Routes>
    </div>
    </Router>
  );
}

export default App;
