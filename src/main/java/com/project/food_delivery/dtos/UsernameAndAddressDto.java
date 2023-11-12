package com.project.food_delivery.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsernameAndAddressDto {
    @Schema(description = "Username", example = "nastinka_krd")
    String username;

    @Schema(description = "Address id", example = "0")
    Integer addressId;
}
