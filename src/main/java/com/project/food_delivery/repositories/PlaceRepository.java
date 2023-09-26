package com.project.food_delivery.repositories;

import com.project.food_delivery.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Optional<Place> findByName(String name);
    List<Place> findAllByPlaceCategoryPlaceCategory(String placeCategory);
}
