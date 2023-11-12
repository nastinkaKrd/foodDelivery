package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
public class PlaceDto {
    @Schema(description = "Name", example = "Metro")
    private String name;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = PlaceCategoryDto.class)
    ))
    private PlaceCategoryDto placeCategory;

    @Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = AddressDto.class)
    ))
    private List<AddressDto> addresses;
}
