package com.project.food_delivery.services;

import com.project.food_delivery.models.Token;
import com.project.food_delivery.models.User;

import java.util.List;

public interface TokenService {
    void saveToken(Token token);
    List<Token> getTokensByUser(User user);
    void updateTokens(List<Token> tokens);
}
