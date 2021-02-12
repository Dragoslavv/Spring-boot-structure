package com.example.demo.service;

import com.example.demo.dto.UserData;
import com.example.demo.entity.Users;
import com.example.demo.errorMessages.ErrorMessages;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserData saveUser(UserData user){
        Users users = populateUserEntity(user);
        return populateCustomerData(usersRepository.save(users));
    }

    @Override
    public boolean deleteUsers(Long userId){
        usersRepository.deleteById(userId);
        return true;
    }

    @Override
    public List<UserData> getAllUsers() {
        List<UserData> users = new ArrayList<>();
        List<Users> usersList = usersRepository.findAll();

        usersList.forEach(user -> {
            users.add(populateCustomerData(user));
        });

        return users;
    }

    @Override
    public UserData getUserId(Long userId){
        return populateCustomerData(usersRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(ErrorMessages.BAD_USER)) );
    }

    private UserData populateCustomerData(final Users users){
        UserData userData = new UserData();

        userData.setId(users.getId());
        userData.setFirstName(users.getFirstName());
        userData.setLastName(users.getLastName());
        userData.setEmail(users.getEmail());

        return userData;
    }

    private Users populateUserEntity(UserData userData) {
        Users users = new Users();

        users.setFirstName(userData.getFirstName());
        users.setLastName(userData.getLastName());
        users.setEmail(userData.getEmail());

        return users;
    }

}
