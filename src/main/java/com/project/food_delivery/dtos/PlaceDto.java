package com.project.food_delivery.dtos;

import lombok.Data;
import java.util.List;

@Data
public class PlaceDto {
    private String name;
    private PlaceCategoryDto placeCategory;
    private List<AddressDto> addressDtos;
}
