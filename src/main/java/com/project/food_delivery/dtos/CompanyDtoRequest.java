package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CompanyDtoRequest {
    @Schema(description = "Name", example = "Tasty fruit")
    private String name;
}
