package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class AddressDto {
    private String city;

    private String street;

    private String buildingNum;
}
