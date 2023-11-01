package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/save-in-memory")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveInMemory(@RequestBody ProductMetadataDto productMetadata){
        productService.saveProductInMemory(productMetadata);
    }

    @GetMapping("/get-all-from-memory")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductMemoryValueData> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get-product-from-memory")
    @ResponseStatus(HttpStatus.OK)
    public ProductMemoryValueData getProductByKey(@RequestBody ProductMetadataDto productMetadataDto){
        return productService.getProductByKey(productMetadataDto);
    }

    @DeleteMapping("/delete-from-memory")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteProduct(@RequestBody ProductMetadataDto productMetadataDto){
        productService.deleteProductFromMemory(productMetadataDto);
    }

    @PutMapping("/increase-product-amount")
    @ResponseStatus(HttpStatus.OK)
    private void addOneMoreProduct(@RequestBody ProductMetadataDto productMetadata){
        productService.addOneMoreProduct(productMetadata);
    }

    @PutMapping("/decrease-product-amount")
    @ResponseStatus(HttpStatus.OK)
    private void deleteOneProduct(@RequestBody ProductMetadataDto productMetadata){
        productService.deleteOneProduct(productMetadata);
    }

}
