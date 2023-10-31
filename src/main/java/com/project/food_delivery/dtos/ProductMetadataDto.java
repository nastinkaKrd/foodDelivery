package com.project.food_delivery.dtos;

import lombok.Data;
import java.util.List;

@Data
public class ProductMetadataDto{
    private String name;
    private ProductCategoryDto productCategory;
    private ProductCharacteristicDto productCharacteristic;
    private List<CompanyDtoRequest> companies;
    private PlaceDto place;
}
