package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.User;
import com.project.food_delivery.response_bodies.UserInformation;

import java.util.List;

public interface UserService {
    List<UserInformation> getUserInformationByUsername(String username);
    User getUserByUsername(String username);
    Address changeUserAddressByUsername(String username, Address address);
    void addUserAddressByUsername(String username, Address address);
    void deleteUserAddressByUsername(UsernameAndAddress usernameAndAddress);
    void deleteUserAccount(String username);
}
