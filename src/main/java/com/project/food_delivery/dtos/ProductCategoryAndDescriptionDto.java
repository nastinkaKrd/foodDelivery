package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductCategoryAndDescriptionDto {
    @Schema(description = "Product category", example = "fruit")
    private String category;
    @Schema(description = "Product description", example = "Ukrainian fruit")
    private String description;
}
