package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class ProductJoinCompanyDto {
    private ProductMetadataDto productMetadata;
    private CompanyDtoResponse company;
}
