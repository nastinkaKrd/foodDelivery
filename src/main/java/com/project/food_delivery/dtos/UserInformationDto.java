package com.project.food_delivery.dtos;

import lombok.Data;
import java.util.List;

@Data
public class UserInformationDto {
    private String username;
    private String email;
    private String phoneNumber;
    private List<AddressDto> addresses;
}
