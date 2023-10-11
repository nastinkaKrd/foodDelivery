package com.project.food_delivery.repositories;

import com.project.food_delivery.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductMetadata, Integer> {
    List<ProductMetadata> findAllByProductCategory_ProductCategory(String category);
    Optional<ProductMetadata> findByNameAndProductCategory_ProductCategoryAndPlace_NameAndProductCharacteristic_PriceAndProductCharacteristic_WeightAndProductCharacteristic_AvailableAmountAndProductCharacteristic_WeightMeasurement(String name, String productCategory_productCategory, String place_name, Double productCharacteristic_price, Double productCharacteristic_weight, Integer productCharacteristic_availableAmount, WeightMeasurement weightMeasurement);
}
