import '../App.css';
import {Link} from 'react-router-dom';

function Navbar() {

const navStyle ={
    color: "white"
  
};

  return (
    <nav>
      <ul className="nav-links">
        <Link style={navStyle} to="/">
          <li> Home </li>
        </Link>
        <Link style={navStyle} to="/login">
          <li> Login </li>
        </Link>
        <Link style={navStyle} to="/sqrls">
          <li> Your Table </li>
        </Link>
      </ul>
    </nav>
  );
}

export default Navbar;
