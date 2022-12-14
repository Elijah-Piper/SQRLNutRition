package com.genspark.SQRLNutRitionAPI.Dao;

import com.genspark.SQRLNutRitionAPI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
