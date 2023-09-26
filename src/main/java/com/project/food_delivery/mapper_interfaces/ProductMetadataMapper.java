package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductMetadataDTO;
import com.project.food_delivery.models.ProductMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProductCharacteristicMapper.class, ProductCategoryMapper.class})
public interface ProductMetadataMapper {
    ProductMetadataDTO productMetadataToDTO(ProductMetadata productMetadata);
    ProductMetadata productMetadataToModel(ProductMetadataDTO productMetadataDTO);
}
