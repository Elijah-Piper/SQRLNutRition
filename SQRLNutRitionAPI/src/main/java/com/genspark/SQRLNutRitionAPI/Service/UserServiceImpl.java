package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Dao.UserDao;
import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.UserConf.Error.UserAlreadyExistException;
import com.genspark.SQRLNutRitionAPI.UserConf.Registration.Dto;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(Dto dto) throws UserAlreadyExistException {
        User user = new User(dto);
        try {
            getUserByUsername(dto.getUsername());
            throw new UserAlreadyExistException("There is an account with that username: " + dto.getUsername());
        } catch (RuntimeException ex)    {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userDao.save(user);
        }
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
//        User user = new User(dto);
//        try {
//            getUserByUsername(dto.getUsername());
//            throw new UserAlreadyExistException("There is an account with that username: " + dto.getUsername());
//       } catch (RuntimeException ex)    {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            createUser(user);
//        }
//        return userDao.save(user);
        return this.createUser(dto);
    }

    @Override
    public String encodePassword(String pw) {
        return passwordEncoder.encode(pw);
    }
}
