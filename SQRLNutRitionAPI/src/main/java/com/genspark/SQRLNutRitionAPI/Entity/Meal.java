package com.genspark.SQRLNutRitionAPI.Entity;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Meal {

    @Id
    @Column(name = "meal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mealId;

    private LocalDateTime createdOn;
    private LocalDateTime eatenOn;

    private String name;

    private int calories;
    private int protein;
    private int carbs;
    private int fat;

    public Meal() {
        this.createdOn = LocalDateTime.now();
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getEatenOn() {
        return eatenOn;
    }

    public void setEatenOn(LocalDateTime eatenOn) {
        this.eatenOn = eatenOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
//                ", squirrel=" + squirrel +
                ", createdOn=" + createdOn +
                ", eatenOn=" + eatenOn +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", protein=" + protein +
                ", carbs=" + carbs +
                ", fat=" + fat +
                '}';
    }
}
