package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.models.WeightMeasurement;
import org.springframework.data.jpa.domain.Specification;

public interface ProductMetadataSpecificationBuildingService {
    Specification<ProductMetadata> filterByName(String name);
    Specification<ProductMetadata> filterByProductCategory(String category);
    Specification<ProductMetadata> filterByPlaceName(String placeName);
    Specification<ProductMetadata> filterByPrice(Double price);
    Specification<ProductMetadata> filterByWeight(Double weight);
    Specification<ProductMetadata> filterByAvailableAmount(Integer availableAmount);
    Specification<ProductMetadata> filterByWeightMeasurement(WeightMeasurement weightMeasurement);
}
