package com.genspark.SQRLNutRitionAPI.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Squirrel {

    @Id
    @Column(name = "squirrelId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int squirrelId;

    @ManyToOne
    @JoinColumn(name = "username")
    private User owner;

    @OneToMany(mappedBy = "squirrel")
    private List<Meal> meals;

    private String name;
    @Column(nullable = true)
    private double weight;
    @Column(nullable = true)
    private boolean isMale;

    private LocalDateTime createdOn;

    public Squirrel(int squirrelId, User owner, List<Meal> meals, String name, double weight, boolean isMale) {
        this.squirrelId = squirrelId;
        this.owner = owner;
        this.meals = meals;
        this.name = name;
        this.weight = weight;
        this.isMale = isMale;
        this.createdOn = LocalDateTime.now();
    }

    public Squirrel() {
    }

    public int getSquirrelId() {
        return squirrelId;
    }

    public void setSquirrelId(int squirrelId) {
        this.squirrelId = squirrelId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
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
                ", owner=" + owner +
                ", meals=" + meals +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", isMale=" + isMale +
                ", createdOn=" + createdOn +
                '}';
    }
}
