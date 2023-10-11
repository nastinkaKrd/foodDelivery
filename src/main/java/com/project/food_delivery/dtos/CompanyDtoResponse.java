package com.project.food_delivery.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class CompanyDtoResponse {
    private String name;
    private List<ProductMetadataDto> productMetadata;
}
