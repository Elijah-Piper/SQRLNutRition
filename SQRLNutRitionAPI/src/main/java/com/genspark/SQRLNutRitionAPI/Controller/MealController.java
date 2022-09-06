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

    @PostMapping("/create")
    public Meal createMeal(@RequestBody Meal meal) {
        return this.mealService.createMeal(meal);
    }

    @GetMapping("/getbyid/{id}")
    public Meal getMealById(@PathVariable int id) {
        return this.mealService.getMealById(id);
    }

    @GetMapping("/getmealsbysquirrel")
    public List<Meal> getMealsBySquirrel(@RequestBody Squirrel sqrl) {
        return this.mealService.getMealsBySquirrel(sqrl);
    }

    @PutMapping("/update")
    public Meal updatemeal(@RequestBody Meal meal) {
        return this.mealService.updateMeal(meal);
    }

    @DeleteMapping("/deletemealbyid{id}")
    public String deleteMealById(@PathVariable int id) {
        return this.mealService.deleteMealById(id);
    }

    @DeleteMapping("/deletemealsbysquirrel")
    public String deleteMealsBySquirrel(@RequestBody Squirrel sqrl) {
        return this.mealService.deleteMealsBySquirrel(sqrl);
    }
}
