package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AuthResponseDto;
import com.project.food_delivery.dtos.AuthenticationRequest;
import com.project.food_delivery.dtos.RegisterRequest;

public interface AuthenticationService {
    AuthResponseDto register(RegisterRequest registerRequest);

    AuthResponseDto authenticate(AuthenticationRequest authRequest);

    void revokeAllUserTokens(String username);

}
