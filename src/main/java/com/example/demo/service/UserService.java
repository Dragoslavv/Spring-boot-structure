package com.example.demo.service;

import com.example.demo.dao.IUserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// Service Components are the class file which contains @Service annotation.
// These class files are used to write business logic in a different layer,
// separated from @RestController class file.
// Observe that in this tutorial, we are using Product Service API(s) to store, retrieve, update and delete
// the products. We wrote the business logic in @RestController class file itself.
// Now, we are going to move the business logic code from controller to service component.

@Service
public class UserService implements IUserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public void createUser(UserDto user) {

    }
    @Override
    public void updateUser(String id, UserDto user) {

    }
    @Override
    public void deleteUser(String id) {

    }
    @Override
    public List<UserDto> getUsers() {
//        return (List<UserDto>) repository.findAll();
        return null;
    }
}
