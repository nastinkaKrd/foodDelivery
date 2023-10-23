package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.models.Address;

public interface AddressService {
    void deleteAddressById(Integer id);
    Address changeAddress(AddressDto addressDto);
    Address addNewAddress(AddressDto addressDto);
}
