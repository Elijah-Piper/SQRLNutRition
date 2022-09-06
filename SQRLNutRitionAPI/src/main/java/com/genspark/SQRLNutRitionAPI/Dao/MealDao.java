package com.genspark.SQRLNutRitionAPI.Dao;

import com.genspark.SQRLNutRitionAPI.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealDao extends JpaRepository<Meal, Integer> {
}
