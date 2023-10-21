package com.project.food_delivery.services;

import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.PlaceCategoryMapper;
import com.project.food_delivery.models.PlaceCategory;
import com.project.food_delivery.repositories.PlaceCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaceCategoryServiceImplements implements PlaceCategoryService{
    private final PlaceCategoryRepository placeCategoryRepository;
    private final PlaceCategoryMapper placeCategoryMapper;

    @Override
    public List<PlaceCategoryDto> getPlaceCategories() {
        List<PlaceCategory> placeCategories = placeCategoryRepository.findAll();
        if (placeCategories.isEmpty()){
            throw new ApiRequestExceptionNotFound("There are no place category");
        }
        return placeCategories.stream().map(placeCategoryMapper::placeCategoryToPlaceCategoryDto).toList();
    }

    @Override
    public PlaceCategory addPlaceCategoryAndReturn(String placeCategory) {
        if (placeCategoryRepository.findPlaceCategoryByPlaceCategory(placeCategory).isEmpty()){
            PlaceCategory placeCategoryModel = PlaceCategory.builder()
                                                            .placeCategory(placeCategory).build();
            placeCategoryRepository.save(placeCategoryModel);
        }
        return placeCategoryRepository.findPlaceCategoryByPlaceCategory(placeCategory).get();
    }
}
