package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.repositories.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImplements implements ProductCategoryService{
    ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> getProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public void addProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }
}
