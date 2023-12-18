package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AuthResponseDto;
import com.project.food_delivery.dtos.AuthenticationRequest;
import com.project.food_delivery.dtos.RegisterRequest;
import com.project.food_delivery.models.Token;
import com.project.food_delivery.models.User;
import com.project.food_delivery.models.UserRoles;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationServiceImplements implements AuthenticationService{
    private final UserService userService;
    private final TokenService tokenService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponseDto register(RegisterRequest registerRequest) {
        var user = User .builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .active(true)
                .userRoles(UserRoles.USER)
                .build();
        userService.saveUser(user);
        String jwtToken = jwtService.generateToken(user);
        saveUserToken(user, jwtToken);
        return AuthResponseDto.builder()
                .jwt(jwtToken).build();
    }

    @Override
    public AuthResponseDto authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));
        User user = userService.getUserByUsername(authenticationRequest.getUsername());
        String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user.getUsername());
        saveUserToken(user, jwtToken);
        return AuthResponseDto.builder()
                .jwt(jwtToken).build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token
                .builder()
                .token(jwtToken)
                .isRevoked(false)
                .isExpired(false)
                .user(user)
                .build();
        tokenService.saveToken(token);
    }


    @Override
    public void revokeAllUserTokens(String username) {
        List<Token> tokens = tokenService.getTokensByUser(username);
        List<Token> validUserTokens = new ArrayList<>();
        for(Token token: tokens){
            if (!token.getIsExpired() && !token.getIsRevoked()){
                validUserTokens.add(token);
            }
        }
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setIsExpired(true);
            token.setIsRevoked(true);
        });
        tokenService.updateTokens(validUserTokens);
    }
}
