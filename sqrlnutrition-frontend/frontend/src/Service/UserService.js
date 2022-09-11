import axios from 'axios';

const USER_API_URL = "http://localhost:8080/user"

class UserService {

    // GET / READ
    getAllUsers() {
        // Returns a list of all user objects
        return axios.get(USER_API_URL + "/getall");
    }

    getUserByUsername(username) {
        // returns a single user that matches the given username string
        return axios.get(USER_API_URL + "/getbyusername/" + username);
    }

    // CREATE / UPDATE
    createUser(userRequestBodyJSON) {
        // Creates a new user matching the JSON provided, ex: {"username": "user123", ...}
        return axios.post(USER_API_URL + "/create", userRequestBodyJSON)
    }

    updateUser(userRequestBodyJSON) {
        // Updates a user info to the JSON that's provided, I believe simply by searching for the primary key, which is just the username (not sure if we can change that easily without making new account)
        return axios.put(USER_API_URL + "/update", userRequestBodyJSON)
    }

    // DELETE
    deleteUserByUsername(username) {
        return axios.delete(USER_API_URL + "/deletebyusername/" + username);
    }
}

export default new UserService();