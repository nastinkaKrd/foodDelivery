package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.User;
import com.project.food_delivery.repositories.UserRepository;
import com.project.food_delivery.response_bodies.UserInformation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplements implements UserService{
    UserRepository userRepository;
    @Override
    public List<UserInformation> getUserInformationByUsername(String username) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Address changeUserAddressByUsername(String username, Address address) {
        return null;
    }

    @Override
    public void addUserAddressByUsername(String username, Address address) {

    }

    @Override
    public void deleteUserAddressByUsername(UsernameAndAddress usernameAndAddress) {

    }

    @Override
    public void deleteUserAccount(String username) {

    }
}
