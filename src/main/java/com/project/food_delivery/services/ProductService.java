package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.ProductData;
import com.project.food_delivery.models.ProductMetadata;

import java.util.List;

public interface ProductService {

    void addProduct(ProductData productData);
}
