package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Entity.Meal;
import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;

import java.util.List;

public interface MealService {

    // CREATE / UPDATE
    Squirrel createMeal(Meal meal, int squirrelId);
    Meal updateMeal(Meal meal);

    // GET / READ
    List<Meal> getMealsBySquirrel(Squirrel sqrl);
    Meal getMealById(int id);

    // DELETE
    String deleteMealsBySquirrel(Squirrel sqrl);
    String deleteMealById(int id);
}
