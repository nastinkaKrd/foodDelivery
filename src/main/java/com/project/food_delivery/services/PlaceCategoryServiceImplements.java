package com.project.food_delivery.services;

import com.project.food_delivery.models.PlaceCategory;
import com.project.food_delivery.repositories.PlaceCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaceCategoryServiceImplements implements PlaceCategoryService{
    PlaceCategoryRepository placeCategoryRepository;

    @Override
    public List<PlaceCategory> getPlaceCategories() {
        return placeCategoryRepository.findAll();
    }
}
