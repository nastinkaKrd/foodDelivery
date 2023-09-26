package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.User;

public interface UserService {
    User getUserByUsername(String username);
    void deleteUserAccount(String username);
    boolean isUserExists(String username);
}
