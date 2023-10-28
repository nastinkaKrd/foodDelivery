package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMetadataDto;
import java.util.List;

public interface ProductService {
    List<ProductMetadataDto> findProductInformationByProductCategory(String category);

    void addProduct(ProductDataDto productData);
}
