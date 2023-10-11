package com.project.food_delivery.services;

import com.project.food_delivery.dtos.PlaceDataDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.models.Place;
import java.util.List;

public interface PlaceService {
    List<PlaceDto> getPlacesByPlaceCategory(String category);

    List<PlaceDto> getPlacesByCity(String city);

    void addPlace(PlaceDataDto placeData);

    Place returnPlaceIfExists(String place);

}
