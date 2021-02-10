package com.example.demo.controller;

import com.example.demo.dto.UsersData;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping
    public List< UsersData > getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UsersData getUser(@PathVariable Long id){
        return userService.getUserId(id);
    }
}
