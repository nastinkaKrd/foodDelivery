package com.project.food_delivery.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AddressDTO {
    private String city;

    private String street;

    private String buildingNum;
}
