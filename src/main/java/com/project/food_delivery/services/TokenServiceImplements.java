package com.project.food_delivery.services;

import com.project.food_delivery.models.Token;
import com.project.food_delivery.repositories.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TokenServiceImplements implements TokenService{
    private final TokenRepository tokenRepository;

    @Override
    public void saveToken(Token token) {
        tokenRepository.save(token);
    }

    @Override
    public List<Token> getTokensByUser(String username) {
        return tokenRepository.findByUser_Username(username);
    }

    @Override
    public void updateTokens(List<Token> tokens) {
        tokenRepository.saveAll(tokens);
    }
}
