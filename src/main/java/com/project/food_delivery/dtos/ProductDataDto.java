package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductDataDto {
    @Schema(description = "Name", example = "Apple")
    private String name;

    @Schema(description = "Product category", example = "fruit")
    private String category;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductCharacteristicDto.class)
    ))
    private ProductCharacteristicDto productCharacteristic;

    @Schema(description = "Place", example = "Metro")
    private String place;

    @Schema(description = "Company", example = "Tasty fruit")
    private String company;
}
