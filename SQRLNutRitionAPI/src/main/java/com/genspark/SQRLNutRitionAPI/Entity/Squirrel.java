package com.genspark.SQRLNutRitionAPI.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Squirrel {

    @Id
    @Column(name = "squirrel_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int squirrelId;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Meal.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "squirrel_id_fk", referencedColumnName = "squirrel_id")
    private List<Meal> meals;

    private String name;

    private LocalDateTime createdOn;

    public Squirrel() {
        this.createdOn = LocalDateTime.now();
        this.meals = new ArrayList<Meal>();
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public int getSquirrelId() {
        return squirrelId;
    }

    public void setSquirrelId(int squirrelId) {
        this.squirrelId = squirrelId;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Squirrel{" +
                "squirrelId=" + squirrelId +
                ", meals=" + meals +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
