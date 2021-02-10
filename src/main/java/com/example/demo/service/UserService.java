package com.example.demo.service;

import com.example.demo.dto.UsersData;

import java.util.List;

public interface UserService {

    public abstract UsersData saveUser(UsersData user);
    public abstract boolean deleteUsers(Long userId);
    public abstract List< UsersData > getAllUsers();
    public abstract UsersData getUserId(Long userId);
}
