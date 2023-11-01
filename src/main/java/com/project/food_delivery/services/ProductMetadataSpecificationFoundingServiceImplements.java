package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductDataForFinding;
import com.project.food_delivery.models.ProductMetadata;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMetadataSpecificationFoundingServiceImplements implements ProductMetadataSpecificationFoundingService{
    private final ProductMetadataSpecificationBuildingService productMetadataSpecificationBuildingService;

    @Override
    public Specification<ProductMetadata> returnProductSpecification(ProductDataForFinding productDataForFinding) {
        Specification<ProductMetadata> spec = Specification.where(null);

        if (productDataForFinding.getName() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByName(productDataForFinding.getName()));
        }

        if (productDataForFinding.getCategory() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByProductCategory(productDataForFinding.getCategory()));
        }

        if (productDataForFinding.getPlace() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPlaceName(productDataForFinding.getPlace()));
        }

        if (productDataForFinding.getProductCharacteristic().getPrice() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPrice(productDataForFinding.getProductCharacteristic().getPrice()));
        }

        if (productDataForFinding.getProductCharacteristic().getWeight() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeight(productDataForFinding.getProductCharacteristic().getWeight()));
        }

        if (productDataForFinding.getProductCharacteristic().getAvailableAmount() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByAvailableAmount(productDataForFinding.getProductCharacteristic().getAvailableAmount()));
        }

        if (productDataForFinding.getProductCharacteristic().getWeightMeasurement() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeightMeasurement(productDataForFinding.getProductCharacteristic().getWeightMeasurement()));
        }
        return spec;
    }
}
