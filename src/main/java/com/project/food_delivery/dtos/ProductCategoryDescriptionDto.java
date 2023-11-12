package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductCategoryDescriptionDto {
    @Schema(description = "Product category description", example = "Ukrainian fruit")
    private String categoryDescription;
}
