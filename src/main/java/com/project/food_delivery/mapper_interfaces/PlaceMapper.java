package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.models.Place;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PlaceCategoryDto.class)
public interface PlaceMapper {
    PlaceDto placeToDTO(Place place);
}
