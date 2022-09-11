package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Dao.UserDao;
import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.UserConf.Error.UserAlreadyExistException;
import com.genspark.SQRLNutRitionAPI.UserConf.Registration.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> u = this.userDao.findById(username);
        User user = null;
        if (u.isPresent()) {
            user = u.get();
        } else {
            throw new RuntimeException("User not found for username :: " + username);
        }

        return user;
    }

    @Override
    public String deleteUserByUsername(String username) {
        this.userDao.deleteById(username);
        return "Successfully deleted user";
    }
    @Override
    public User registerNewUserAccount(Dto dto) throws UserAlreadyExistException {
        User user = new User(dto);
        try {
            getUserByUsername(dto.getUsername());
            throw new UserAlreadyExistException("There is an account with that username: " + dto.getUsername());
       } catch (RuntimeException ex)    {
            createUser(user);
        }
        return user;
    }
}
