package com.project.food_delivery.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCharacteristicDTO {
    private Float price;
    private Float weight;
    private Integer availableAmount;
    private String weightMeasurement;
}
