package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.models.PlaceCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceCategoryMapper {
    PlaceCategoryDto placeCategoryToPlaceCategoryDTO(PlaceCategory placeCategory);
}
