package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class ProductDataForFinding {
    private String name;
    private String category;
    private ProductCharacteristicDto productCharacteristic;
    private String place;
}
