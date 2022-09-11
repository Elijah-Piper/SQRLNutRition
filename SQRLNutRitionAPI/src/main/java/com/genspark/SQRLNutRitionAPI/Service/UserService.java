package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.UserConf.Registration.Dto;

import java.util.List;

public interface UserService {

    // CREATE / UPDATE
    User createUser(User user);
    User updateUser(User user);

    // GET / READ
    List<User> getAllUsers();
    User getUserByUsername(String username);

    // DELETE
    String deleteUserByUsername(String username);
    User registerNewUserAccount(Dto dto);
}
