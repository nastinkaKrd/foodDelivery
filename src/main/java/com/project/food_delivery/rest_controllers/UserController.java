package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.UsernameAndAddressDto;
import com.project.food_delivery.dtos.UserInformationDto;
import com.project.food_delivery.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/{username}")
    public UserInformationDto getUserInformationByUsername(@PathVariable(name = "username") String username){
        return userService.findUserInformationByUsername(username);
    }

    @PutMapping("/{username}")
    public AddressDto changeUserAddressByUsername(@PathVariable(name = "username") String username, @RequestBody AddressDto addressDto){
        return userService.changeUserAddressByUsername(username, addressDto);
    }

    @DeleteMapping("/address")
    public void deleteUserAddressByUsername(@RequestBody UsernameAndAddressDto usernameAndAddress){
        userService.deleteUserAddressByUsername(usernameAndAddress);
    }

    @DeleteMapping("/{username}")
    public void deleteUserAccount(@PathVariable(name = "username") String username){
        userService.deleteUserAccount(username);
    }

    @PostMapping("/address/{username}")
    public void addUserAddressByUsername(@PathVariable(name = "username") String username, @RequestBody AddressDto addressDto){
        userService.addUserAddressByUsername(username, addressDto);
    }
}
