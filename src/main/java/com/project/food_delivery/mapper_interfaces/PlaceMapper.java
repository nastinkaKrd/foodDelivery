package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.models.Place;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
    PlaceDto placeToDto(Place place);
}
