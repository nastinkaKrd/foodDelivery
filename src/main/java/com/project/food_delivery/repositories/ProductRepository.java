package com.project.food_delivery.repositories;

import com.project.food_delivery.models.ProductMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductMetadata, Integer> {
}
