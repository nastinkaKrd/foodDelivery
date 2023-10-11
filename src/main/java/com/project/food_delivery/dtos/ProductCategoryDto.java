package com.project.food_delivery.dtos;

import com.project.food_delivery.models.ProductCategoryDescription;
import lombok.Data;

@Data
public class ProductCategoryDto {
    private String productCategory;
    private ProductCategoryDescription productCategoryDescription;
}
