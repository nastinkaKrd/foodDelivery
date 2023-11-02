package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductDataForFinding;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestProductDataMapper {
    ProductDataForFinding convertRequestDataToFinding(ProductDataDto productDataDto);
}
