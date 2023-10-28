package com.project.food_delivery.repositories;

import com.project.food_delivery.models.PlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, Integer> {
    Optional<PlaceCategory> findPlaceCategoryByPlaceCategory(String placeCategory);
}
