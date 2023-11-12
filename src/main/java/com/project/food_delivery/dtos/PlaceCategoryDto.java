package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PlaceCategoryDto {
    @Schema(description = "Place category", example = "Supermarket")
    private String placeCategory;
}
