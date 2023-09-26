package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.dtos.PlaceDTO;
import com.project.food_delivery.dtos.PlaceJoinAddressDTO;
import com.project.food_delivery.models.PlacesJoinAddresses;

import java.util.List;

public interface PlaceJoinAddressService {
    void addNewData(AddressDTO addressDTO, PlaceDTO placeDTO);
    List<PlaceJoinAddressDTO> findAllByCity(String city);

}
