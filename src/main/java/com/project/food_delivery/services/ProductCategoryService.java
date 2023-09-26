package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.ProductCategoryAndDescription;
import com.project.food_delivery.dtos.ProductCategoryDTO;


import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDTO> getProductCategories();

    void addProductCategory(ProductCategoryAndDescription productCategoryAndDescription);
}
