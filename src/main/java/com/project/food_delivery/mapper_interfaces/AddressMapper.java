package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address addressDTOToModel(AddressDTO addressDTO);
    AddressDTO addressToDTO(Address address);
}
