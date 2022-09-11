import '../App.css';

const data = [
  {squirrels: ["Nuts", "Susan", "Fluffy"]}//these will be objects, not strings
]
const i = 0;
function Table() {
  return (
    <div className="App">
      <h1>
        Squirrels
      </h1>
      <table>
        
        <thead>
        <p>{
          data.map((value, key) => {
            return (
              <h1 key={key}> {value.squirrels[i]} </h1>
            )
          })
        }</p>
          <tr>
            <th>Meal</th>
            <th>Protein</th>
            <th>Carbs</th>
            <th>Fats</th>
            <th>Calories</th>
          </tr>
        </thead>
        <tbody>
          {
            meals.map((element, index) => {
              return (
                <tr index={index}>
                  <td>{element.mealname}</td>
                  <td>{element.protein}</td>
                  <td>{element.carbs}</td>
                  <td>{element.fats}</td>
                  <td>{element.cals}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  );
}

export default Table;