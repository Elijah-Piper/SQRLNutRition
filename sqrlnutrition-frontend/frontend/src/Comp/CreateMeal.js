import '../App.css';
import { useParams } from 'react-router-dom'
import {useRef, useState, useEffect} from 'react';
import MealService from '../Service/MealService';


function CreateM(props) {
  const {sqrlid} = useParams();

  const mealRef = useRef();
  const errRef = useRef();

  const [name,setName] = useState('');
  const [calories,setCalories] = useState('');
  const [protein,setProtein] = useState('');
  const [carbs,setCarbs] = useState('');
  const [fat, setFat] = useState('');
  const [errMsg,setErrMsg] = useState('');
  const [succ,setSucc] = useState('');



  useEffect(() => {
    mealRef.current.focus();
  }, [])

  useEffect(() => {
    setErrMsg('');
  }, [name])

  const handleSubmit = async (e) => {
    e.preventDefault();
    MealService.createMeal(
      sqrlid,
      {
        "name": name,
        "calories": calories,
        "protein": protein,
        "carbs": carbs,
        "fat": fat 
      })
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
        <input type="text" id="name" ref={mealRef} autoComplete="off" onChange={(e) => setName(e.target.value)} value={name} required/>
        <label htmlFor="prot"> Calories: </label>
        <input type="number" id="calories" ref={mealRef} autoComplete="off" onChange={(e) => setCalories(e.target.value)} value={calories} required/>
        <label htmlFor="prot"> Protein: </label>
        <input type="number" id="protein" ref={mealRef} autoComplete="off" onChange={(e) => setProtein(e.target.value)} value={protein} required/>
        <label htmlFor="carbs"> Carbs: </label>
        <input type="number" id="carbs" ref={mealRef} autoComplete="off" onChange={(e) => setCarbs(e.target.value)} value={carbs} required/>
        <label htmlFor="fats"> Fat: </label>
        <input type="number" id="fat" ref={mealRef} autoComplete="off" onChange={(e) => setFat(e.target.value)} value={fat} required/>
        <button>Go Nuts</button>
      </form>
    </section>
    )}
    </>
    );
  }
  
  export default CreateM;