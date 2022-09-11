import axios from 'axios';
const SQUIRREL_API_URL = "http://localhost:8080/squirrel"

class SquirrelService {

    // GET / READ
    getSquirrelById(id) {
        // id is Squirrel primary key in DB : integer
        return axios.get(SQUIRREL_API_URL + "/getbyid/" + id);
    }

    getSquirrelsByUsername(username) {
        // Returns a list of all squirrels belonging the the User whose username string is given
        return axios.get(SQUIRREL_API_URL + "/getbyusername" + username);
    }

    // CREATE / UPDATE
    createSquirrelsForUser(username, squirrelRequestBodyJSON) {
        // Creates the squirrel object provided by the JSON, bound the the user with the given username string
        return axios.post(SQUIRREL_API_URL + "/create/" + username, squirrelRequestBodyJSON);
    }

    updateSquirrel(squirrelRequestBodyJSON) {
        // Updates a squirrel object to the information provided in new JSON squirrel obj; squirrel to update found by id (don't believe we can easily change that)
        return axios.put(SQUIRREL_API_URL + "/update", squirrelRequestBodyJSON);
    }

    // DELETE
    deleteSquirrelById(id) {
        // Deletes a single squirrel with the given integer id
        return axios.delete(SQUIRREL_API_URL + "/deletebyid/" + id);
    }

    deleteSquirrelsByUsername(username) {
        // Deletes every squirrels bound to the user account with the given username
        return axios.delete(SQUIRREL_API_URL + "/deletebyusername/" + username);
    }
}

export default new SquirrelService();