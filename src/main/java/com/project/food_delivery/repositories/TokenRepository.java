package com.project.food_delivery.repositories;

import com.project.food_delivery.models.Token;
import com.project.food_delivery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    List<Token> findByUser(User user);

    Optional<Token> findByToken(String jwt);
}
