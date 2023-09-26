package com.project.food_delivery.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlaceJoinAddressDTO {
    PlaceDTO place;
    AddressDTO address;
}
