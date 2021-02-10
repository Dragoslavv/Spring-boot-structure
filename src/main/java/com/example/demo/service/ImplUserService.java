package com.example.demo.service;

import com.example.demo.dto.UsersData;
import com.example.demo.entity.Users;
import com.example.demo.errorMessages.ErrorMessages;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class ImplUserService implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersData saveUser(UsersData user){
        Users users = populateUserEntity(user);
        return populateCustomerData(usersRepository.save(users));
    }

    @Override
    public boolean deleteUsers(Long userId){
        usersRepository.deleteById(userId);
        return true;
    }

    @Override
    public List< UsersData > getAllUsers() {
        List< UsersData > users = new ArrayList<>();
        List< Users > usersList = usersRepository.findAll();

        usersList.forEach(user -> {
            users.add(populateCustomerData(user));
        });

        return users;
    }

    @Override
    public UsersData getUserId(Long userId){
        return populateCustomerData(usersRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(ErrorMessages.BAD_USER)) );
    }

    private UsersData populateCustomerData(final Users users){
        UsersData usersData = new UsersData();

        usersData.setId(users.getId());
        usersData.setFirstName(users.getFirstName());
        usersData.setLastName(users.getLastName());
        usersData.setEmail(users.getEmail());

        return usersData;
    }

    private Users populateUserEntity(UsersData usersData) {
        Users users = new Users();

        users.setFirstName(usersData.getFirstName());
        users.setLastName(usersData.getLastName());
        users.setEmail(usersData.getEmail());

        return users;
    }

}
