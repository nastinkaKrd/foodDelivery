package com.project.food_delivery.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class PlaceDTO {
    private String name;
    private PlaceCategoryDTO placeCategory;
}
