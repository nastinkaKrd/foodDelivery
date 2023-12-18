package com.project.food_delivery.services;

import com.project.food_delivery.models.Token;

import java.util.List;

public interface TokenService {
    void saveToken(Token token);
    List<Token> getTokensByUser(String username);
    void updateTokens(List<Token> tokens);
}
