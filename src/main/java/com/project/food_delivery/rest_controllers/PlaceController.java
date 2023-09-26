package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.RequestBodies.PlaceData;
import com.project.food_delivery.dtos.PlaceDTO;
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
    @GetMapping("?place-category='category'")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceDTO> getPlacesByPlaceCategory(@RequestParam(name = "category") String category){
        return placeService.getPlacesByPlaceCategory(category);
    }

    @GetMapping("?city='city'")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceDTO> getPlacesByCity(@RequestParam(name = "city") String city){
        return placeService.getPlacesByCity(city);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlace(@RequestBody PlaceData placeData){
        placeService.addPlace(placeData);
    }
}
