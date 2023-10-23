package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.models.WeightMeasurement;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMetadataSpecificationFoundingServiceImplements implements ProductMetadataSpecificationFoundingService{
    private final ProductMetadataSpecificationBuildingService productMetadataSpecificationBuildingService;
    @Override
    public Specification<ProductMetadata> findAndReturnProductMetadataSpecification(String name, String category, String placeName, Double price, Double weight, Integer availableAmount, WeightMeasurement weightMeasurement) {
        Specification<ProductMetadata> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByName(name));
        }

        if (category != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByProductCategory(category));
        }

        if (placeName != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPlaceName(placeName));
        }

        if (price != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPrice(price));
        }

        if (weight != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeight(weight));
        }

        if (availableAmount != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByAvailableAmount(availableAmount));
        }

        if (weightMeasurement != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeightMeasurement(weightMeasurement));
        }
        return spec;
    }
}
