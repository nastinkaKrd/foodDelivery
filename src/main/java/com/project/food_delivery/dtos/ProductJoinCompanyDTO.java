package com.project.food_delivery.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJoinCompanyDTO {
    private ProductMetadataDTO productMetadata;
    private CompanyDTO company;
}
