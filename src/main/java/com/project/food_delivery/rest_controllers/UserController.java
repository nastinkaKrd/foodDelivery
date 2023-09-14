package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.response_bodies.UserInformation;
import com.project.food_delivery.services.UserService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {
    UserService userService;
    @GetMapping("/{username}")
    public List<UserInformation> getUserInformationByUsername(@PathVariable String username){
        return userService.getUserInformationByUsername(username);
    }

    @PutMapping("/{username}")
    public Address changeUserAddressByUsername(@PathVariable String username, @RequestBody Address address){
        return userService.changeUserAddressByUsername(username, address);
    }

    @DeleteMapping("/address")
    public void deleteUserAddressByUsername(@RequestBody UsernameAndAddress usernameAndAddress){
        userService.deleteUserAddressByUsername(usernameAndAddress);
    }

    @DeleteMapping("/{username}")
    public void deleteUserAccount(@PathVariable String username){
        userService.deleteUserAccount(username);
    }
}
