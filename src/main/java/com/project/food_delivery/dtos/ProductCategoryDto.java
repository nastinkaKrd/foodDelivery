package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class ProductCategoryDto {
    private String productCategory;
    private ProductCategoryDescriptionDto productCategoryDescription;
}
