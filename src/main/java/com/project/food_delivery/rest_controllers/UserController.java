package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.UserInformationDto;
import com.project.food_delivery.dtos.UsernameAndAddressDto;
import com.project.food_delivery.exceptions.ErrorResponse;
import com.project.food_delivery.services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@OpenAPIDefinition(
        info = @Info(
                title = "User controller",
                version = "1.0",
                description = "Controller that processes user data"
        )
)
public class UserController {
    private final UserService userService;
    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get user information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found user information",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserInformationDto.class))}),
            @ApiResponse(responseCode = "404", description = "Information is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse .class))})
    })
    public ResponseEntity<UserInformationDto> getUserInformationByUsername(@Parameter(description = "Username", example = "nastinka_krd") @PathVariable(name = "username") String username){
        return ResponseEntity.ok(userService.findUserInformationByUsername(username));
    }

    @PutMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Change user address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User address is changed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressDto.class))}),
            @ApiResponse(responseCode = "404", description = "User is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse .class))}),
            @ApiResponse(responseCode = "404", description = "Address is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse .class))})
    })
    public ResponseEntity<AddressDto> changeUserAddressByUsername(@Parameter(description = "Username", example = "nastinka_krd") @PathVariable(name = "username") String username,
                                                  @Parameter(required = true, content = @Content(
                                                          mediaType = "application/json",
                                                          schema = @Schema(implementation = AddressDto.class)
                                                  )) @RequestBody AddressDto addressDto){
        return ResponseEntity.ok(userService.changeUserAddressByUsername(username, addressDto));
    }

    @DeleteMapping("/address")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete user address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User address is deleted"),
            @ApiResponse(responseCode = "404", description = "User is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse .class))})
    })
    public void deleteUserAddressByUsername(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = UsernameAndAddressDto.class)
    ))@RequestBody UsernameAndAddressDto usernameAndAddress){
        userService.deleteUserAddressByUsername(usernameAndAddress);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete user account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User account is deleted"),
            @ApiResponse(responseCode = "404", description = "User is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse .class))})
    })
    public void deleteUserAccount(@Parameter(description = "Username", example = "nastinka_krd") @PathVariable(name = "username") String username){
        userService.deleteUserAccount(username);
    }

    @PostMapping("/address/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create user address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User address is created"),
            @ApiResponse(responseCode = "404", description = "User is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse .class))})
    })
    public void addUserAddressByUsername(@Parameter(description = "Username", example = "nastinka_krd") @PathVariable(name = "username") String username,
                                         @Parameter(required = true, content = @Content(
                                                 mediaType = "application/json",
                                                 schema = @Schema(implementation = AddressDto.class)
                                         )) @RequestBody AddressDto addressDto){
        userService.addUserAddressByUsername(username, addressDto);
    }
}
