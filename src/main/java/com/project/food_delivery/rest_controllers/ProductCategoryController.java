package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.services.ProductCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/product-categories")
public class ProductCategoryController {
    ProductCategoryService productCategoryService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductCategory> getProductCategories(){
        return productCategoryService.getProductCategories();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductCategory(@RequestBody ProductCategory productCategory){
        productCategoryService.addProductCategory(productCategory);
    }
}
