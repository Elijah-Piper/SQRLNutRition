import '../App.css';
import {Link} from 'react-router-dom';
import { useEffect } from 'react';

function Navbar() {

  const navStyle ={
    color: "white"

  };

  const clearUser = () => {
    localStorage.removeItem("signedInUsername");
  }

  function LoginLink() {
    return (
      <Link style={navStyle} to="/login">
        <li> Login </li>
      </Link>
    );
  }
  function LogoutLink() {
    return (
      <Link style={navStyle} to="/" onClick={ clearUser() }>
        <li> Logout </li>
      </Link>
    );
  }

  return (
    <nav>
      <ul className="nav-links">
        <Link style={navStyle} to="/">
          <li> Home </li>
        </Link>
        <Link style={navStyle} to="/sqrls">
          <li> Your Table </li>
        </Link>
        <LoginLink/>
        <LogoutLink/>
        <h3 style={navStyle}>
          { localStorage.getItem("signedInUsername") ? "Hello, " + localStorage.getItem("signedInUsername") : "Please login or create an account" }
        </h3>
      </ul>
    </nav>
  );
}

export default Navbar;
