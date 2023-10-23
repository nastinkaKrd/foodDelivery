package com.project.food_delivery.dtos;

import lombok.Data;

@Data
public class AddressDto {
    private Integer id;

    private String city;

    private String street;

    private String buildingNum;
}
