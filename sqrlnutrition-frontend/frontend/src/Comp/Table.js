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
    SquirrelService.getSquirrelsByUsername("JonathanJoestar").then((Response) => {
      console.log(Response);
      this.setState({ squirrels: Response.data})
    })
  }

  render(){

    console.log("Render State: ");
    console.log(this.state);
    return(
      <div>
          <h2 className="text-center">REST Extracted List</h2>
          <table className="table table-striped">
              <thead>
                  <tr>
                      <td> Squirrel Id</td>
                      <td> Squirrel Name</td>
                      <td> Date Created</td>
                  </tr>
              </thead>
              <tbody>
                  {
                      this.state.squirrels.map(
                          sqrl => 
                          <tr key= { sqrl.squirrelId }>
                              <td> { sqrl.squirrelId }</td>
                              <td> { sqrl.name }</td>
                              <td> { sqrl.createdOn }</td>
                          </tr>
                      )
                  }
              </tbody>
          </table>
      </div>
    )
  }
}

export default Table;