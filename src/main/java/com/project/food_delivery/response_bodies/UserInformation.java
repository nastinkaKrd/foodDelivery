package com.project.food_delivery.response_bodies;

import com.project.food_delivery.dtos.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserInformation {
    private String username;
    private String email;
    private String phoneNumber;
    private List<AddressDTO> addressDTOS;
}
