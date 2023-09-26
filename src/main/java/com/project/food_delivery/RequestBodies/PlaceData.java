package com.project.food_delivery.RequestBodies;

import com.project.food_delivery.dtos.AddressDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlaceData {
    String name;
    AddressDTO address;
    String placeCategory;
}
