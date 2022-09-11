package com.genspark.SQRLNutRitionAPI.Controller;

import com.genspark.SQRLNutRitionAPI.Entity.Meal;
import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Put React server address here
@RestController
@RequestMapping("meal/")
public class MealController {

    @Autowired
    private MealService mealService;

    @PostMapping("/create/{squirrelId}")
    public Squirrel createMeal(@RequestBody Meal meal, @PathVariable int squirrelId) {
        return this.mealService.createMeal(meal, squirrelId);
    }

    @GetMapping("/getbyid/{id}")
    public Meal getMealById(@PathVariable int id) {
        return this.mealService.getMealById(id);
    }

    @GetMapping("/getbysquirrel")
    public List<Meal> getMealsBySquirrel(@RequestBody Squirrel sqrl) {
        return this.mealService.getMealsBySquirrel(sqrl);
    }

    @PutMapping("/update")
    public Meal updatemeal(@RequestBody Meal meal) {
        return this.mealService.updateMeal(meal);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteMealById(@PathVariable int id) {
        return this.mealService.deleteMealById(id);
    }

    @DeleteMapping("/deletebysquirrel")
    public String deleteMealsBySquirrel(@RequestBody Squirrel sqrl) {
        return this.mealService.deleteMealsBySquirrel(sqrl);
    }
}
