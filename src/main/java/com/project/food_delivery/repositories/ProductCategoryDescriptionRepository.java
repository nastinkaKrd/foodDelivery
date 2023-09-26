package com.project.food_delivery.repositories;

import com.project.food_delivery.models.ProductCategoryDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDescriptionRepository extends JpaRepository<ProductCategoryDescription, Integer> {
}
