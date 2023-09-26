package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.PlaceData;
import com.project.food_delivery.dtos.PlaceDTO;
import java.util.List;

public interface PlaceService {
    List<PlaceDTO> getPlacesByPlaceCategory(String category);

    List<PlaceDTO> getPlacesByCity(String city);

    void addPlace(PlaceData placeData);
}
