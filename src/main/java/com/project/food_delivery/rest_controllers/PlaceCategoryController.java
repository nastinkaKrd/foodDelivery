package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.PlaceCategoryDTO;
import com.project.food_delivery.services.PlaceCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/place-categories")
public class PlaceCategoryController {
    private final PlaceCategoryService placeCategoryService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceCategoryDTO> getPlaceCategories(){
        return placeCategoryService.getPlaceCategories();
    }

    @PostMapping("/{place-category}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPlaceCategory(@PathVariable(name = "place-category") String placeCategory){
        placeCategoryService.addPlaceCategory(placeCategory);
    }
}
