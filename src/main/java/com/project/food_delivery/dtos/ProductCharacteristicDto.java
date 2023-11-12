package com.project.food_delivery.dtos;

import com.project.food_delivery.models.WeightMeasurement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductCharacteristicDto {
    @Schema(description = "Price", example = "12.1")
    private Double price;

    @Schema(description = "Weight", example = "3.5")
    private Double weight;

    @Schema(description = "Available amount", example = "10")
    private Integer availableAmount;

    @Schema(description = "Weight measurement", example = "KILOS")
    private WeightMeasurement weightMeasurement;
}
