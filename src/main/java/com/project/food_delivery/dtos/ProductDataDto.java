package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class ProductDataDto {
    private String name;
    private String category;
    private ProductCharacteristicDto productCharacteristic;
    private String place;
    private String company;
}
