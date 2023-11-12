package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
public class ProductMetadataDto{
    @Schema(description = "Name", example = "Apple")
    private String name;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductCategoryDto.class)
    ))
    private ProductCategoryDto productCategory;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductCharacteristicDto.class)
    ))
    private ProductCharacteristicDto productCharacteristic;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = CompanyDtoRequest.class)
    ))
    private List<CompanyDtoRequest> companies;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = PlaceDto.class)
    ))
    private PlaceDto place;
}
