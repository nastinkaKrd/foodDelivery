package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getProductCategories();

    void addProductCategory(ProductCategory productCategory);
}
