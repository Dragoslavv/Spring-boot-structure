package com.example.demo.service;

import com.example.demo.dto.UsersData;

import java.util.List;

public interface UserService {

    UsersData saveUser(UsersData user);
    boolean deleteUsers(final Long userId);
    List< UsersData > getAllUsers();
    UsersData getUserId(final Long userId);
}
