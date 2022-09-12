import '../App.css';
import {useRef, useState, useEffect} from 'react';
import SqrlServ from '../Service/SquirrelService.js';

function CreateM() {
  const mealRef = useRef();
  const errRef = useRef();

  const [meal,setMeal] = useState('');
  const [prot,setProt] = useState('');
  const [carbs,setCarbs] = useState('');
  const [fats, setFats] = useState('');
  const [errMsg,setErrMsg] = useState('');
  const [succ,setSucc] = useState('');



  useEffect(() => {
    mealRef.current.focus();
  }, [])

  useEffect(() => {
    setErrMsg('');
  }, [meal])

  const handleSubmit = async (e) => {
  e.preventDefault();
    // SqrlServ.createSquirrelsForUser( this.props.user,{
    //     "name": sqrl
    // })
    setSucc(true)
}
    return (
      <>
      {succ ? (
        <section>
          <h1> Meal Created Successfully</h1>
        </section>
      ) : (

      
    <section>
      <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive"> {errMsg}</p>
      <h1> Enter Meal Details</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="meal"> Meal Name:</label>
        <input type="text" id="meal" ref={mealRef} autoComplete="off" onChange={(e) => setMeal(e.target.value)} value={meal} required/>
        <label htmlFor="prot"> Protein: </label>
        <input type="number" id="prot" ref={mealRef} autoComplete="off" onChange={(e) => setProt(e.target.value)} value={prot} required/>
        <button>Go Nuts</button>
      </form>
    </section>
    )}
    </>
    );
  }
  
  export default CreateM;