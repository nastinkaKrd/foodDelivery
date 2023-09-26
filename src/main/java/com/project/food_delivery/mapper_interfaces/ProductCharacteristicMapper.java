package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCharacteristicDTO;
import com.project.food_delivery.models.ProductCharacteristic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductCharacteristicMapper {
    ProductCharacteristicDTO productCharacteristicToDTO(ProductCharacteristic productCharacteristic);
    ProductCharacteristic productCharacteristicDTOToModel(ProductCharacteristicDTO productCharacteristicDTO);
}
