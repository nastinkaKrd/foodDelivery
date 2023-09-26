package com.project.food_delivery.repositories;

import com.project.food_delivery.models.UsersJoinAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserJoinAddressRepository extends JpaRepository<UsersJoinAddresses, Integer> {
    List<UsersJoinAddresses> findAllByUser_Username(String username);
    Optional<UsersJoinAddresses> findByUser_UsernameAndAddress_Id(String username, Integer addressId);
}
