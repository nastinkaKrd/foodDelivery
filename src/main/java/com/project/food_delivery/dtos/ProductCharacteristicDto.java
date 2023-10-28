package com.project.food_delivery.dtos;

import com.project.food_delivery.models.WeightMeasurement;
import lombok.Data;

@Data
public class ProductCharacteristicDto {
    private Double price;
    private Double weight;
    private Integer availableAmount;
    private WeightMeasurement weightMeasurement;
}
