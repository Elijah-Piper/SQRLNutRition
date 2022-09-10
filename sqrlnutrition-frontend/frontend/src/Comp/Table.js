import '../App.css';

const data = [
  {squirrels: ["Nuts", "Susan", "Fluffy"]}//these will be objects, not strings
]
const meals = [
  {mealname: "acorns", protein: 4, carbs: 2, fats: 1, cals: 43}//these will be filled with object values
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
            meals.map((value, key) => {
              return (
                <tr key={key}>
                  <td>{value.mealname}</td>
                  <td>{value.protein}</td>
                  <td>{value.carbs}</td>
                  <td>{value.fats}</td>
                  <td>{value.cals}</td>
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