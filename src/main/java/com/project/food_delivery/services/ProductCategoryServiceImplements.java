package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.ProductCategoryAndDescription;
import com.project.food_delivery.dtos.ProductCategoryDTO;
import com.project.food_delivery.mapper_interfaces.ProductCategoryMapper;
import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.models.ProductCategoryDescription;
import com.project.food_delivery.repositories.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImplements implements ProductCategoryService{
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryDescriptionService productCategoryDescriptionService;
    @Override
    public List<ProductCategoryDTO> getProductCategories() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return productCategories.stream().map(productCategoryMapper::productCategoryToDTO).toList();
    }

    @Override
    public void addProductCategory(ProductCategoryAndDescription productCategoryAndDescription) {
        if (productCategoryRepository.findByProductCategory(productCategoryAndDescription.getCategory()).isEmpty()){
            productCategoryDescriptionService.addDescription(productCategoryAndDescription.getDescription());
            productCategoryRepository.save(new ProductCategory(productCategoryAndDescription.getCategory(),
                    new ProductCategoryDescription(productCategoryAndDescription.getDescription())));
        }else {
            //will be handler exception
        }
    }
}
