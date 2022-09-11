import axios from 'axios';

const MEAL_API_URL = "http://localhost:8080/meal"

class MealService {

    // GET / READ
    getMealById(id) {
        // Retrieves a single meal object with the given integer id
        return axios.get(MEAL_API_URL + "/getbyid/" + id);
    }

    getMealsBySquirrel(squirrelRequestBodyJSON) {
        // Retrieves a list of all meals belonging to the squirrel object specified in the request body JSON
        return axios.get(MEAL_API_URL + "/getbysquirrel", squirrelRequestBodyJSON);
    }

    // CREATE / UPDATE
    createMeal(squirrelId, mealRequestBodyJSON) {
        // Creates a new meal from the request body JSON, assigning it the the squirrel with the given integer squirrelId
        return axios.post(MEAL_API_URL + "/create/" + squirrelId, mealRequestBodyJSON);
    }

    updateMeal(mealRequestBodyJSON) {
        // Updates a meal, using the provided JSON meal object (I don't believe we can change the meal id easily, as that's likely how it's fetched)
        return axios.put(MEAL_API_URL + "/update", mealRequestBodyJSON);
    }

    // DELETE
    deleteMealById(id) {
        // Deletes a single meal from DB with the given integer meal id primary key
        return axios.delete(MEAL_API_URL + "/deletebyid/" + id);
    }

    deleteMealsBySquirrel(squirrelRequestBodyJSON) {
        // Deletes all meals belonging to the squirrel object defined in the request body JSON
        return axios.delete(MEAL_API_URL + "/deletebysquirrel", squirrelRequestBodyJSON);
    }
}

export default new MealService();