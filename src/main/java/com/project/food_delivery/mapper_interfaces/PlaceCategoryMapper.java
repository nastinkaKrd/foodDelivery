package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.PlaceCategoryDTO;
import com.project.food_delivery.models.PlaceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlaceCategoryMapper {
    PlaceCategoryDTO placeCategoryToPlaceCategoryDTO(PlaceCategory placeCategory);
    PlaceCategory placeCategoryToModel(PlaceCategoryDTO placeCategoryDTO);
}
