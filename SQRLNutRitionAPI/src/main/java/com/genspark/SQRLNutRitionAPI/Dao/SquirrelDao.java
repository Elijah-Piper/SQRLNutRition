package com.genspark.SQRLNutRitionAPI.Dao;

import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquirrelDao extends JpaRepository<Squirrel, Integer> {
}
