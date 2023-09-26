package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.RequestBodies.ProductData;
import com.project.food_delivery.dtos.ProductJoinCompanyDTO;
import com.project.food_delivery.services.ProductJoinCompanyService;
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
    private final ProductJoinCompanyService productJoinCompanyService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductJoinCompanyDTO> getProductsByProductCategory(@RequestParam(name = "category") String category){
        return productJoinCompanyService.findProductInformationByProductCategory(category);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductData productData){
        productService.addProduct(productData);
    }
}
