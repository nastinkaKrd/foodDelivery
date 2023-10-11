package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.ProductCategoryAndDescriptionDto;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.services.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductCategoryDto> getProductCategories(){
        return productCategoryService.getProductCategories();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductCategory(@RequestBody ProductCategoryAndDescriptionDto productCategoryAndDescription){
        productCategoryService.addProductCategory(productCategoryAndDescription);
    }
}
