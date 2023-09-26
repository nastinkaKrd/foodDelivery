package com.project.food_delivery.repositories;

import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.PlacesJoinAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaceJoinAddressRepository extends JpaRepository<PlacesJoinAddresses, Integer> {
    List<PlacesJoinAddresses> findAllByAddress(Address address);
    List<PlacesJoinAddresses> findAllByAddress_City(String city);
}
