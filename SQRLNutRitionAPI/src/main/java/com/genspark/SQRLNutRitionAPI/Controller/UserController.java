package com.genspark.SQRLNutRitionAPI.Controller;

import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "") // Put React server address here
@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/getusername/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return this.userService.getUserByUsername(username);
    }

    @GetMapping("/getallusers")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PutMapping("/updateuser")
    public User updateUser(User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/deleteuserbyusername")
    public String deleteUserByUsername(String username) {
        return this.userService.deleteUserByUsername(username);
    }
}
