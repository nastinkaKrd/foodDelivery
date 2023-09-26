package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.response_bodies.UserInformation;

public interface UserJoinAddressService {
    UserInformation findUserInformationByUsername(String username);
    AddressDTO changeUserAddressByUsername(String username, AddressDTO address, Integer address_id);
    void addUserAddressByUsername(String username, AddressDTO addressDTO);
    void deleteUserAddressByUsername(UsernameAndAddress usernameAndAddress);
}
