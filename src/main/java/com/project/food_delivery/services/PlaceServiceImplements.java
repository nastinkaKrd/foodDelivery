package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.PlaceData;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceServiceImplements implements PlaceService{
    PlaceRepository placeRepository;

    @Override
    public List<Place> getPlacesByPlaceCategory(String category) {
        return null;
    }

    @Override
    public List<Place> getPlacesByCity(String city) {
        return null;
    }

    @Override
    public void addPlace(PlaceData placeData) {

    }
}
