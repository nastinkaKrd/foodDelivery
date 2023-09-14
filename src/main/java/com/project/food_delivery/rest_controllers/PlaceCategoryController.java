package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.models.PlaceCategory;
import com.project.food_delivery.services.PlaceCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/place-categories")
public class PlaceCategoryController {
    PlaceCategoryService placeCategoryService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceCategory> getPlaceCategories(){
        return placeCategoryService.getPlaceCategories();
    }

}
