package com.project.food_delivery.repositories;

import com.project.food_delivery.models.PlacesJoinAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceJoinAddressRepository extends JpaRepository<PlacesJoinAddresses, Integer> {
}
