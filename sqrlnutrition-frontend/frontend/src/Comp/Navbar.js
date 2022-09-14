import '../App.css';
import {Link} from 'react-router-dom';
import { useEffect } from 'react';

  const navStyle ={
    color: "white"

  };

  const clearUser = () => {
    localStorage.removeItem("signedInUsername");
    window.location.reload();
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
      <Link style={navStyle} to="/" onClick={() => clearUser() }>
        <li> Logout </li>
      </Link>
    );
  }

function Navbar() {

  var user = localStorage.getItem("signedInUsername");
  return (
    <nav>
      <ul className="nav-links">
        <Link style={navStyle} to="/">
          <li> Home </li>
        </Link>
	    { user ? <Link style={navStyle} to="/sqrls">
          <li> Your Table </li>
        </Link> : '' }
	    { user ? '' : <LoginLink/> }
	    { user ? <LogoutLink/> :  ''}
        <h3 style={navStyle}>
          { user ? "Hello, " + user : "Please login or create an account" }
        </h3>
        { user === "admin" ? <Link style={navStyle} to="/admin">
		  <li> Admin Page </li> 
		</Link> : '' }
      </ul>
    </nav>
  );
}

export default Navbar;
