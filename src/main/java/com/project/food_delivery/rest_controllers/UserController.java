package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.response_bodies.UserInformation;
import com.project.food_delivery.services.UserJoinAddressService;
import com.project.food_delivery.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserJoinAddressService userJoinAddressService;
    @GetMapping("/{username}")
    public UserInformation getUserInformationByUsername(@PathVariable(name = "username") String username){
        return userJoinAddressService.findUserInformationByUsername(username);
    }

    @PutMapping("/{username}")
    public AddressDTO changeUserAddressByUsername(@PathVariable(name = "username") String username, @RequestBody AddressDTO address
            , @RequestParam(name = "address_id") Integer address_id){
        return userJoinAddressService.changeUserAddressByUsername(username, address, address_id);
    }

    @DeleteMapping("/address")
    public void deleteUserAddressByUsername(@RequestBody UsernameAndAddress usernameAndAddress){
        userJoinAddressService.deleteUserAddressByUsername(usernameAndAddress);
    }

    @DeleteMapping("/{username}")
    public void deleteUserAccount(@PathVariable(name = "username") String username){
        userService.deleteUserAccount(username);
    }

    @PostMapping("/address/{username}")
    public void addUserAddressByUsername(@PathVariable(name = "username") String username, @RequestBody AddressDTO addressDTO){
        userJoinAddressService.addUserAddressByUsername(username, addressDTO);
    }
}
