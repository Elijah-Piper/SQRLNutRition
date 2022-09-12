import '../App.css';
import {useRef, useState, useEffect} from 'react';
import SqrlServ from '../Service/SquirrelService.js';

function CreateS() {
  const sqrlRef = useRef();
  const errRef = useRef();

  const [sqrl,setSqrl] = useState('');
  const [errMsg,setErrMsg] = useState('');
  const [succ,setSucc] = useState('');



  useEffect(() => {
    sqrlRef.current.focus();
  }, [])

  useEffect(() => {
    setErrMsg('');
  }, [sqrl])

  const handleSubmit = async (e) => {
  e.preventDefault();
    SqrlServ.createSquirrelsForUser( "user123",{
        "name": sqrl
    })
    
    setSucc(true)
}
    return (
      <>
      {succ ? (
        <section>
          <h1> Squirrel Added Successfully</h1>
        </section>
      ) : (

      
    <section>
      <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive"> {errMsg}</p>
      <h1> Enter Squirrel Name</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="squirrelname"> Squirrel Name:</label>
        <input type="text" id="squirrelname" ref={sqrlRef} autoComplete="off" onChange={(e) => setSqrl(e.target.value)} value={sqrl} required/>
        <button>Go Nuts</button>
      </form>
    </section>
    )}
    </>
    );
  }
  
  export default CreateS;