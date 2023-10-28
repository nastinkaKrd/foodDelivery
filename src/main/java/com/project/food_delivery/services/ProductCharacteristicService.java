package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductCharacteristicDto;
import com.project.food_delivery.models.ProductCharacteristic;

public interface ProductCharacteristicService {
    ProductCharacteristic addProductCharacteristic(ProductCharacteristicDto productCharacteristicDto);
}
