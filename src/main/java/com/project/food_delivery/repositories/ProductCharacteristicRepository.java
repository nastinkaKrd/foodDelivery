package com.project.food_delivery.repositories;

import com.project.food_delivery.models.ProductCharacteristic;
import com.project.food_delivery.models.WeightMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductCharacteristicRepository extends JpaRepository<ProductCharacteristic, Integer> {
}
