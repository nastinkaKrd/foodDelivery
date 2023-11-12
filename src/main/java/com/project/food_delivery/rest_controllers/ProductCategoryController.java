package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.ProductCategoryAndDescriptionDto;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.services.ProductCategoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product-categories")
@OpenAPIDefinition(
        info = @Info(
                title = "Product category controller",
                version = "1.0",
                description = "Controller that add and return product category data"
        )
)
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get product categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product categories are found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductCategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Product categories are not found", content = @Content(mediaType = "text/plain"))
    })
    public List<ProductCategoryDto> getProductCategories(){
        return productCategoryService.getProductCategories();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add new product category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product category is added", content = @Content(mediaType = "text/plain")),
    })
    public void addProductCategory(@Parameter(description = "Product category", example = "fruit") @RequestBody ProductCategoryAndDescriptionDto productCategoryAndDescription){
        productCategoryService.addProductCategory(productCategoryAndDescription);
    }
}
