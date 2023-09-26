package com.project.food_delivery.services;

import com.project.food_delivery.dtos.PlaceCategoryDTO;

import java.util.List;

public interface PlaceCategoryService {
    List<PlaceCategoryDTO> getPlaceCategories();

    void addPlaceCategory(String placeCategory);
}
