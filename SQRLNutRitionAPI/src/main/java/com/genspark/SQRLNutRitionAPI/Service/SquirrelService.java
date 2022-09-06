package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Entity.User;

import java.util.List;

public interface SquirrelService {

    // CREATE / UPDATE
    Squirrel createSquirrel(Squirrel sqrl);
    Squirrel updateSquirrel(Squirrel sqrl);

    // GET / READ
    List<Squirrel> getSquirrelsByUser(User user);
    Squirrel getSquirrelById(int id);

    // DELETE
    String deleteSquirrelsByUser(User user); // Deletes all squirrels for given user
    String deleteSquirrelById(int id);
}
