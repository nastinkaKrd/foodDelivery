package com.project.food_delivery.services;

import com.project.food_delivery.dtos.PlaceCategoryDTO;
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
    public List<PlaceCategoryDTO> getPlaceCategories() {
        List<PlaceCategory> placeCategories = placeCategoryRepository.findAll();
        return placeCategories.stream().map(placeCategoryMapper::placeCategoryToPlaceCategoryDTO).toList();
    }

    @Override
    public void addPlaceCategory(String placeCategory) {
        if (placeCategoryRepository.findPlaceCategoryByPlaceCategory(placeCategory).isEmpty()){
            placeCategoryRepository.save(new PlaceCategory(placeCategory));
        }else {
            //will be handler exception
        }
    }
}
