package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.ProductData;
import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplements implements ProductService{
    ProductRepository productRepository;
    @Override
    public List<ProductMetadata> getProductsByProductCategory(String category) {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(ProductData productData) {
        productRepository.save(new ProductMetadata());
    }
}
