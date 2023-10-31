package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.dtos.ProductMetadataDto;

import java.util.List;

public interface ProductService {
    ProductMemoryValueData getProductByKey(ProductMetadataDto productMetadataDto);

    void deleteProductFromMemory(ProductMetadataDto productMetadataDto);

    List<ProductMetadataDto> findProductInformationByProductCategory(String category);

    void addProduct(ProductDataDto productData);

    void saveProductInMemory(ProductMetadataDto productMetadata);

    List<ProductMemoryValueData> getAllProducts();

    void addOneMoreProduct(ProductMetadataDto productMetadata);

    void deleteOneProduct(ProductMetadataDto productMetadata);
}
