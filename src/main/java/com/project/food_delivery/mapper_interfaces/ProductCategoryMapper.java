package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.models.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategoryDto productCategoryToDto(ProductCategory productCategory);
}
