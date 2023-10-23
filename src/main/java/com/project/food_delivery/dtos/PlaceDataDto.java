package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class PlaceDataDto {
    String name;
    AddressDto address;
    String placeCategory;
}
