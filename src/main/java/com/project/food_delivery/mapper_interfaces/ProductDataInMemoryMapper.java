package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductDataForFinding;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDataInMemoryMapper {
    @Mapping(target = "category", source = "productCategory.productCategory")
    @Mapping(target = "place", source = "place.name")
    ProductDataForFinding convertProductFromMemoryToFinding(ProductMemoryValueData productMemoryValueData);
}
