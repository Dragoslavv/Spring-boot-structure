package com.example.demo.dao;

import com.example.demo.dto.UserDto;
import java.util.List;

// create an Interface which contains add, edit, get and delete
// methods using the code as shown below −
public interface IUserDao {

    public abstract void createUser(UserDto user); //add product model
    public abstract void updateUser(String id, UserDto user);
    public abstract void deleteUser(String id);
    public abstract List<UserDto> getUsers();

}
