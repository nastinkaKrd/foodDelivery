package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.RequestBodies.ProductData;
import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    @GetMapping("")
    public List<ProductMetadata> getProductsByProductCategory(@RequestParam(name = "category") String category){
        return productService.getProductsByProductCategory(category);
    }

    @PostMapping("")
    public void addProduct(@RequestBody ProductData productData){
        productService.addProduct(productData);
    }
}
