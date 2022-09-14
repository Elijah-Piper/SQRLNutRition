import '../App.css';
import {useRef, useState, useEffect} from 'react';
import UserService from '../Service/UserService.js';

const users = {
  usernames: [],
  objs: [],
};

const setUsers = () => {
  UserService.getAllUsers().then((Response) => {
    users.objs = Response.data;
    users.objs.forEach((user) => {
      users.usernames.push(user.username);
    });
  });
  return new Promise((resolve) => {
    resolve();
  });
}

setUsers();

function Login() {
  const userRef = useRef();
  const errRef = useRef();

  const [user,setUser] = useState('');
  const [pass,setPass] = useState('');
  const [errMsg,setErrMsg] = useState('');
  const [succ,setSucc] = useState('');

  useEffect(() => {
      userRef.current.focus();
    }, [])

    useEffect(() => {
      setErrMsg('');
    }, [user,pass])

    const handleSubmit = async (e) => {
      e.preventDefault();

      let passwordValid = null;

      setUsers().then(() => UserService.checkPassword(user, pass).then((Response) => {

        if (users.usernames.includes(user)) { // Checks that username exists in DB

          passwordValid = Response.data;

          console.log("passwordValid:");
          console.log(passwordValid);
          if (passwordValid) { // Checks password
            setSucc(true);
            localStorage.setItem("signedInUsername", user);
          } else {
            setErrMsg("Incorrect password");
          }
        } else {
          setErrMsg("That username does not exist");
        }
      }));
    }

    return (
      <>
      {succ ? (
        <section>
		  <script>
		    setTimeout(function(){window.location.href = '/'}, 5000);
		  </script>
          <h1> You logged in successfully</h1>
        </section>
      ) : (


    <section>
      <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive"> {errMsg}</p>
      <h1> Please Sign In</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="username"> Username</label>
        <input type="text" id="username" ref={userRef} autoComplete="off" onChange={(e) => setUser(e.target.value)} value={user} required/>
        <label htmlFor="password"> Password</label>
        <input type="password" id="password"  autoComplete="off" onChange={(e) => setPass(e.target.value)} value={pass} required/>
        <p>
        <button>Sign In</button>
        </p>
      </form>
    </section>
    )}
    </>
  );
}

  export default Login;
