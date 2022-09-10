import '../App.css';
import {useRef, useState, useEffect} from 'react';

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
  setSucc(true);
}
    return (
      <>
      {succ ? (
        <section>
          <h1> You logged in successfully</h1>
        </section>
      ) : (

      
    <section>
      <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive"> {errMsg}</p>
      <h1> Please Sign In</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="username"> Username:</label>
        <input type="text" id="username" ref={userRef} autoComplete="off" onChange={(e) => setUser(e.target.value)} value={user} required/>
        <label htmlFor="password"> Password:</label>
        <input type="password" id="password"  autoComplete="off" onChange={(e) => setPass(e.target.value)} value={pass} required/>
        <button>Sign In</button>
      </form>
    </section>
    )}
    </>
    );
  }
  
  export default Login;