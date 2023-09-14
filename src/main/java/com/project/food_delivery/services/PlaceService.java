package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.PlaceData;
import com.project.food_delivery.models.Place;


import java.util.List;

public interface PlaceService {
    List<Place> getPlacesByPlaceCategory(String category);

    List<Place> getPlacesByCity(String city);

    void addPlace(PlaceData placeData);
}
