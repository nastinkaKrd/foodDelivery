package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddressDto {
    @Schema(description = "Id", example = "0")
    private Integer id;

    @Schema(description = "Name", example = "Ivano-Frankivsk")
    private String city;

    @Schema(description = "Street", example = "Ivan Mykolaychuk street")
    private String street;

    @Schema(description = "Building number", example = "20")
    private String buildingNum;
}
