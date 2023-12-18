package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.AuthResponseDto;
import com.project.food_delivery.dtos.AuthenticationRequest;
import com.project.food_delivery.dtos.RegisterRequest;
import com.project.food_delivery.exceptions.ErrorResponse;
import com.project.food_delivery.services.AuthenticationService;
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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@OpenAPIDefinition(
        info = @Info(
                title = "Authentication Controller",
                version = "1.0",
                description = "Controller that allow user to authenticate and register"
        )
)
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/get-user-details")
    @ResponseStatus(HttpStatus.OK)
    public String getUserDetails(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails.getUsername();
    }

    @PutMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@AuthenticationPrincipal UserDetails userDetails){
        authenticationService.revokeAllUserTokens(userDetails.getUsername());
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User is registered", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponseDto.class))}),
            @ApiResponse(responseCode = "208", description = "User is already exists", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<AuthResponseDto> register(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = RegisterRequest.class)
    )) @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Authenticate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User is authenticated", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "User is not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<AuthResponseDto> createJwtToken(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = AuthenticationRequest.class)
    )) @RequestBody AuthenticationRequest authRequest)  {
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }
}
