package com.example.demo.controller;

import com.example.demo.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    // The code here show the Rest Controller class file,
    // here we @Autowired the UserDao interface and called the methods.
    private IUserDao users;

}
