package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductCharacteristicDto;
import com.project.food_delivery.mapper_interfaces.ProductCharacteristicMapper;
import com.project.food_delivery.models.ProductCharacteristic;
import com.project.food_delivery.repositories.ProductCharacteristicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCharacteristicServiceImplements implements ProductCharacteristicService{
    private final ProductCharacteristicRepository productCharacteristicRepository;
    private final ProductCharacteristicMapper productCharacteristicMapper;

    @Override
    public ProductCharacteristic addProductCharacteristic(ProductCharacteristicDto productCharacteristicDto) {
        return productCharacteristicRepository.save(productCharacteristicMapper.productCharacteristicDtoToModel(productCharacteristicDto));
    }
}
