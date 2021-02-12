package com.example.demo.service;

import com.example.demo.dto.UserData;

import java.util.List;

public interface UserService {

    UserData saveUser(UserData user);
    boolean deleteUsers(final Long userId);
    List<UserData> getAllUsers();
    UserData getUserId(final Long userId);
}
