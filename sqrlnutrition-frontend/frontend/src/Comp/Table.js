import React from 'react';
import '../App.css';
import {Link} from 'react-router-dom';
import MealService from '../Service/MealService.js';
import SquirrelService from '../Service/SquirrelService.js';
import UserService from '../Service/UserService.js'

// function deleteMeal(id) {
//   MealService.deleteMealById(id);
// }
// function deleteSquirrel(id) {
//   SquirrelService.deleteSquirrelById(id);
// }

const invisBorderStyle = {
  "border": 0,
}

const buttonStyle = {
  "font-size": 16,
  "font-weight": "normal",
}


class Table extends React.Component{

  constructor(props) {
    super(props);
    this.state={
      squirrels:[],
      user: localStorage.getItem("signedInUsername")
    }
  }

  componentDidMount() {
    SquirrelService.getSquirrelsByUsername(localStorage.getItem("signedInUsername")).then((Response) => {
      console.log(Response);
      this.setState({ squirrels: Response.data, user: localStorage.getItem("signedInUsername")})
    })
  }

  render(){

    console.log(this.state.squirrels)
    return(
      <div>
          <h1 className="text-center">Your Squirrels</h1>
          <Link to={{pathname:"/sqrlmake/" + localStorage.getItem("signedInUsername")}}>
            <button style={ buttonStyle }>create new squirrel</button>
          </Link>
                  {
                      this.state.squirrels.map(
                          sqrl => 
                          <div key={ sqrl.squirrelId } className="squirrel-table">
                            <h2 className="text-center"> 
                            Name: { sqrl.name } 
                            {/*
                            <a>
                              <button style={ buttonStyle }>edit squirrel</button>
                            </a>
*/}
                            <button style={ buttonStyle } onClick={ () => SquirrelService.deleteSquirrelById(sqrl.squirrelId)}>delete squirrel</button>
                            </h2>
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <td> Meal Name </td>
                                        <td> Date and Time Eaten </td>
                                        <td> Calories </td>
                                        <td> Protein </td>
                                        <td> Carbohydrates </td>
                                        <td> Fat </td>
                                        <td style={ invisBorderStyle }> 
                                          <Link to={{pathname:"/createmeal/" + sqrl.squirrelId}}>
                                            <button style={ buttonStyle }>add meal</button>
                                          </Link>
                                        </td>
                                    </tr>
                                </thead>
                                <tbody>
                                  { sqrl.meals.map( meal =>
                                    <tr key= { meal.mealId }>
                                      <td> { meal.name } </td>
                                      <td> { meal.eatenOn } </td>
                                      <td> { meal.calories } </td>
                                      <td> { meal.protein }g </td>
                                      <td> { meal.carbs }g </td>
                                      <td> { meal.fat }g </td>
                                      <td style={ invisBorderStyle }>
                                        {/*
                                        <Link to={{pathname:"/updatemeal/" + meal.mealId}}>
                                          <button style={ buttonStyle }>edit</button>
                                        </Link>
                                        } */}
                                        <button style={ buttonStyle } onClick={ () => MealService.deleteMealById(meal.mealId) }>delete</button>
                                      </td>
                                    </tr>
                                    )
                                  }
                                </tbody>
                            </table>
                          </div>
                      )
                  }
      </div>
    )
  }
}

export default Table;