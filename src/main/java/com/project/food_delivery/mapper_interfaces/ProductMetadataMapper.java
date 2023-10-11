package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.models.ProductMetadata;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductCharacteristicMapper.class, ProductCategoryMapper.class})
public interface ProductMetadataMapper {
    ProductMetadataDto productMetadataToDTO(ProductMetadata productMetadata);
}
