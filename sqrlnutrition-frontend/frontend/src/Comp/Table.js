import '../App.css';

const data = [
  {sname:"Nuts", meals:"rodent block, lettuce, acorn", kname: "Steve", lastfed:"13,1,7,20:12"}
]

function Table() {
  return (
    <div className="App">
      <h1>Squirrel Table</h1>
      <table>
        <thead>
          <tr>
            <th>Squirrel Name</th>
            <th>Meals Fed</th>
            <th>Keeper</th>
            <th>Time Last Fed</th>
          </tr>
        </thead>
        <tbody>
          {
            data.map((value, key) => {
              return (
                <tr key={key}>
                  <td>{value.sname}</td>
                  <td>{value.meals}</td>
                  <td>{value.kname}</td>
                  <td>{value.lastfed}</td>
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