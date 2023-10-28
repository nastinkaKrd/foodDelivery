package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.models.ProductMetadata;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMetadataMapper {
    ProductMetadataDto productMetadataToDto(ProductMetadata productMetadata);
}
