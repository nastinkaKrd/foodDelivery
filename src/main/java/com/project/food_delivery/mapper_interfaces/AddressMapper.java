package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    com.project.food_delivery.models.Address addressDtoToModel(AddressDto addressDto);
    AddressDto addressToDto(com.project.food_delivery.models.Address address);
}
