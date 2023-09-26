package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.dtos.PlaceDTO;
import com.project.food_delivery.dtos.PlaceJoinAddressDTO;
import com.project.food_delivery.models.PlacesJoinAddresses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PlaceDTO.class, AddressDTO.class})
public interface PlaceJoinAddressMapper {
    PlaceJoinAddressDTO placeJoinAddressToDTO(PlacesJoinAddresses placesJoinAddresses);

}
