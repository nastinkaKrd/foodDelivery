package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductCategoryDescription;
import com.project.food_delivery.repositories.ProductCategoryDescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryDescriptionServiceImplements implements ProductCategoryDescriptionService{
    private final ProductCategoryDescriptionRepository productCategoryDescriptionRepository;
    @Override
    public ProductCategoryDescription addDescription(String description) {
        return productCategoryDescriptionRepository.findByCategoryDescription(description).orElseGet(() -> {
            ProductCategoryDescription productCategoryDescription = ProductCategoryDescription.builder()
                    .categoryDescription(description).build();
            return productCategoryDescriptionRepository.save(productCategoryDescription);
        });
    }
}
