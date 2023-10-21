package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductCategoryAndDescriptionDto;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionAlreadyReported;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
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
    public List<ProductCategoryDto> getProductCategories() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        if (productCategories.isEmpty()){
            throw new ApiRequestExceptionNotFound("There are no product categories");
        }
        return productCategories.stream().map(productCategoryMapper::productCategoryToDto).toList();
    }

    @Override
    public void addProductCategory(ProductCategoryAndDescriptionDto productCategoryAndDescription) {
        productCategoryRepository.findByProductCategory(productCategoryAndDescription.getCategory()).ifPresentOrElse(
                productCategory -> {
                    throw new ApiRequestExceptionAlreadyReported("This category was added before to database");
                },
                () -> {
                    ProductCategoryDescription productCategoryDescription = productCategoryDescriptionService
                            .addDescription(productCategoryAndDescription.getDescription());
                    ProductCategory productCategory = new ProductCategory();
                    productCategory.setProductCategory(productCategoryAndDescription.getCategory());
                    productCategory.setProductCategoryDescription(productCategoryDescription);
                    productCategoryRepository.save(productCategory);
                }
        );
    }

    @Override
    public ProductCategory returnProductCategoryIfExists(String productCategory) {
        return productCategoryRepository.findByProductCategory(productCategory).orElseThrow(
                () -> new ApiRequestExceptionNotFound("Product category is not found. Please create it")
        );
    }
}
