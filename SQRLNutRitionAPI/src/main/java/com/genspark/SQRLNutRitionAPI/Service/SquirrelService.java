package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Entity.User;

import java.util.List;

public interface SquirrelService {

    // CREATE / UPDATE
    User createSquirrel(Squirrel sqrl, String username);
    Squirrel updateSquirrel(Squirrel sqrl);

    // GET / READ
    List<Squirrel> getSquirrelsByUsername(String username);
    Squirrel getSquirrelById(int id);
    List<Squirrel> getAllSquirrels();

    // DELETE
    String deleteSquirrelsByUser(User user); // Deletes all squirrels for given user
    String deleteSquirrelById(int id);
}
