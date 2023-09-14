package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.RequestBodies.PlaceData;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.services.PlaceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/places")
public class PlaceController {
    PlaceService placeService;
    @GetMapping("?place-category='category'")
    public List<Place> getPlacesByPlaceCategory(@RequestParam(name = "category") String category){
        return placeService.getPlacesByPlaceCategory(category);
    }

    @GetMapping("?city='city'")
    public List<Place> getPlacesByCity(@RequestParam(name = "city") String city){
        return placeService.getPlacesByCity(city);
    }

    @PostMapping("")
    public void addPlace(@RequestBody PlaceData placeData){
        placeService.addPlace(placeData);
    }
}
