package com.project.food_delivery.repositories;

import com.project.food_delivery.models.ProductCategoryDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductCategoryDescriptionRepository extends JpaRepository<ProductCategoryDescription, Integer> {
    Optional<ProductCategoryDescription> findByCategoryDescription(String categoryDescription);
}
