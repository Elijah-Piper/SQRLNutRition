import React from 'react';
import '../App.css';
import MealService from '../Service/MealService.js';
import SquirrelService from '../Service/SquirrelService.js';
import UserService from '../Service/UserService.js'

class Table extends React.Component{

  constructor(props) {
    super(props);
    this.state={
      squirrels:[]
    }
  }

  componentDidMount() {
    SquirrelService.getSquirrelsByUsername("Sbeve").then((Response) => {
      this.setState({ squirrels: Response.data})
    })
  }

  render(){
    return(
      <div>
        <table>
          <thead>
            <tr><td>Name</td></tr>
          </thead>
          <tbody>
            {
              this.state.squirrels.map(squirrel =>
                <tr key= {squirrel.squirrelId}>
                  <td>{squirrel.name}</td>
                </tr>)
            }
          </tbody>
        </table>
      </div>
    )
  }
}

export default Table;