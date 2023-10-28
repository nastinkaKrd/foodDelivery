package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductMetadataDto> getProductsByProductCategory(@RequestParam(name = "category") String category){
        return productService.findProductInformationByProductCategory(category);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductDataDto productData){
        productService.addProduct(productData);
    }



}
