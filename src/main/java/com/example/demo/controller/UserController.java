package com.example.demo.controller;

import com.example.demo.dto.UserData;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserData> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserData getUser(@PathVariable Long id){
        return userService.getUserId(id);
    }

    @PostMapping("/user")
    public UserData saveUser(final @RequestBody UserData userData) {
        return userService.saveUser(userData);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return  userService.deleteUsers(id);
    }
}
