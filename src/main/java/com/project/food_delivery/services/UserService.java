package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.UserInformationDto;
import com.project.food_delivery.dtos.UsernameAndAddressDto;
import com.project.food_delivery.models.User;

public interface UserService {
    UserInformationDto findUserInformationByUsername(String username);
    AddressDto changeUserAddressByUsername(String username, AddressDto addressDto);
    User getUserByUsername(String username);
    void deleteUserAccount(String username);
    void addUserAddressByUsername(String username, AddressDto addressDto);
    void deleteUserAddressByUsername(UsernameAndAddressDto usernameAndAddress);
}
