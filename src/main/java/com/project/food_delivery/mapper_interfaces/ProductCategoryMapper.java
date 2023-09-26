package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCategoryDTO;
import com.project.food_delivery.models.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategoryDTO productCategoryToDTO(ProductCategory productCategory);
    ProductCategory productCategoryDTOToModel(ProductCategoryDTO productCategoryDTO);
}
