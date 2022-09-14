import React from 'react';
import '../App.css';
import MealService from '../Service/MealService.js';
import SquirrelService from '../Service/SquirrelService.js';
import UserService from '../Service/UserService.js'


class Table extends React.Component{

  constructor(props) {
    console.log("Constructor ran");
    super(props);
    this.state={
      squirrels:[]
    }
  }

  componentDidMount() {
    console.log("Component Mounted Response:");
    SquirrelService.getSquirrelsByUsername(localStorage.getItem("signedInUsername")).then((Response) => {
      console.log(Response);
      this.setState({ squirrels: Response.data})
    })
  }

  render(){

    console.log(this.state.squirrels)
    return(
      <div>
          <h1 className="text-center">Your Squirrels</h1>
                  {
                      this.state.squirrels.map(
                          sqrl =>
                          <div key={ sqrl.squirrelId } className="squirrel-table">
                            <h2 className="text-center"> Name: { sqrl.name }</h2>
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <td> Meal Name </td>
                                        <td> Date and Time Eaten </td>
                                        <td> Calories </td>
                                        <td> Protein </td>
                                        <td> Carbohydrates </td>
                                        <td> Fat </td>
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
