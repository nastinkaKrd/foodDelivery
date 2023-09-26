package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.PlaceCategoryDTO;
import com.project.food_delivery.dtos.PlaceDTO;
import com.project.food_delivery.models.Place;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PlaceCategoryDTO.class)
public interface PlaceMapper {
    PlaceDTO placeToDTO(Place place);
    Place placeDTOToModel(PlaceDTO placeDTO);
}
