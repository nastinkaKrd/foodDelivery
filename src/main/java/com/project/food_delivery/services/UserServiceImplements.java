package com.project.food_delivery.services;

import com.project.food_delivery.models.User;
import com.project.food_delivery.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImplements implements UserService{
    private final UserRepository userRepository;
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public void deleteUserAccount(String username) {
        if (isUserExists(username)){
            userRepository.deleteByUsername(username);
        }
    }

    @Override
    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
