package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.models.WeightMeasurement;
import org.springframework.data.jpa.domain.Specification;

public interface ProductMetadataSpecificationFoundingService {
    Specification<ProductMetadata> findAndReturnProductMetadataSpecification(String name, String category, String placeName,
                                                                             Double price, Double weight, Integer availableAmount,
                                                                             WeightMeasurement weightMeasurement);
}
