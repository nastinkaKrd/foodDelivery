package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.exceptions.ErrorResponse;
import com.project.food_delivery.services.ProductService;
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
import org.springframework.http.ResponseEntity;
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
@OpenAPIDefinition(
        info = @Info(
                title = "Product controller",
                version = "1.0",
                description = "Controller that processes product data"
        )
)
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get products by product category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductMetadataDto.class))}),
            @ApiResponse(responseCode = "404", description = "Products are not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<List<ProductMetadataDto>> getProductsByProductCategory(@Parameter(description = "Product category", example = "fruit") @RequestParam(name = "category") String category){
        return ResponseEntity.ok(productService.findProductInformationByProductCategory(category));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add product into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product is added"),
            @ApiResponse(responseCode = "208", description = "Product already exists", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public void addProduct(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductDataDto.class)
    )) @RequestBody ProductDataDto productData){
        productService.addProduct(productData);
    }


    @PostMapping("/save-in-memory")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add product into memory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product is added")
    })
    public void saveInMemory(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductMetadataDto.class)
    )) @RequestBody ProductMetadataDto productMetadata){
        productService.saveProductInMemory(productMetadata);
    }

    @GetMapping("/get-all-from-memory")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get products from memory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductMemoryValueData.class))}),
            @ApiResponse(responseCode = "404", description = "Products are not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<List<ProductMemoryValueData>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/get-product-from-memory")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get product from memory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductMemoryValueData.class))}),
            @ApiResponse(responseCode = "404", description = "Product is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<ProductMemoryValueData> getProductByKey(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductMetadataDto.class)
    ))@RequestBody ProductMetadataDto productMetadataDto){
        return ResponseEntity.ok(productService.getProductByKey(productMetadataDto));
    }

    @DeleteMapping("/delete-from-memory")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete product from memory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product is deleted"),
            @ApiResponse(responseCode = "404", description = "Product is not found", content = @Content(mediaType = "application/json"))
    })
    private void deleteProduct(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductMetadataDto.class)
    ))@RequestBody ProductMetadataDto productMetadataDto){
        productService.deleteProductFromMemory(productMetadataDto);
    }

    @PutMapping("/increase-product-amount")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Add one more product into basket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product is added")
    })
    private void addOneMoreProduct(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductMetadataDto.class)
    ))@RequestBody ProductMetadataDto productMetadata){
        productService.addOneMoreProduct(productMetadata);
    }

    @PutMapping("/decrease-product-amount")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete one pc of product from basket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product is deleted")
    })
    private void deleteOneProduct(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductMetadataDto.class)
    ))@RequestBody ProductMetadataDto productMetadata){
        productService.deleteOneProduct(productMetadata);
    }

}
