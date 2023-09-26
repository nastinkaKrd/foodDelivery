package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDTO;

public interface AddressService {
    void addNewAddress(AddressDTO addressDTO);
    void deleteAddressById(Integer id);
}
