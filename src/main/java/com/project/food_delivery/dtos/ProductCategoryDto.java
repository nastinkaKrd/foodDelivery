package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductCategoryDto {
    @Schema(description = "Product category", example = "fruit")
    private String productCategory;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductCategoryDescriptionDto.class)
    ))
    private ProductCategoryDescriptionDto productCategoryDescription;
}
