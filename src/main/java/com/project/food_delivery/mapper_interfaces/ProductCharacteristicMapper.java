package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCharacteristicDto;
import com.project.food_delivery.models.ProductCharacteristic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCharacteristicMapper {
    ProductCharacteristic productCharacteristicDtoToModel(ProductCharacteristicDto productCharacteristicDto);
}
