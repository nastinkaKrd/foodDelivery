package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductCategoryAndDescriptionDto;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.models.ProductCategory;
import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> getProductCategories();

    void addProductCategory(ProductCategoryAndDescriptionDto productCategoryAndDescription);

    ProductCategory returnProductCategoryIfExists(String productCategory);
}
