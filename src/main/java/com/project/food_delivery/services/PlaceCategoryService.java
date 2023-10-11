package com.project.food_delivery.services;

import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.models.PlaceCategory;
import java.util.List;

public interface PlaceCategoryService {
    List<PlaceCategoryDto> getPlaceCategories();

    PlaceCategory addPlaceCategoryAndReturn(String placeCategory);
}
