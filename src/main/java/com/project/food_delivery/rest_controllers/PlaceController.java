package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.PlaceDataDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.services.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;
    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceDto> getPlacesByPlaceCategory(@RequestParam(name = "category") String category){
        return placeService.getPlacesByPlaceCategory(category);
    }

    @GetMapping("/city")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceDto> getPlacesByCity(@RequestParam(name = "city") String city){
        return placeService.getPlacesByCity(city);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlace(@RequestBody PlaceDataDto placeData){
        placeService.addPlace(placeData);
    }
}
