package com.project.food_delivery.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserInformationDto {
    private String username;
    private String email;
    private String phoneNumber;
    private List<AddressDto> addressDTOS;
}
