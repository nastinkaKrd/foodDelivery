package com.project.food_delivery.models;

import com.project.food_delivery.dtos.ProductMetadataDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Basket {
    private HashMap<Place, List<ProductMetadataDTO>> basketHashMap;
}
