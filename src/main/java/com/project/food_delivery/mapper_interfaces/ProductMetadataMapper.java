package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductDataForFinding;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.models.ProductMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMetadataMapper {
    ProductMetadataDto productMetadataToDto(ProductMetadata productMetadata);

    ProductDataForFinding convertRequestDataToFinding(ProductDataDto productDataDto);

    @Mapping(target = "category", source = "productCategory.productCategory")
    @Mapping(target = "place", source = "place.name")
    ProductDataForFinding convertProductFromMemoryToFinding(ProductMemoryValueData productMemoryValueData);
}
