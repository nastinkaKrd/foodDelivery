package com.project.food_delivery.RequestBodies;

import com.project.food_delivery.dtos.ProductMetadataDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductData {
    private ProductMetadataDTO productMetadataDTO;
    private String place;
    private String company;
}
