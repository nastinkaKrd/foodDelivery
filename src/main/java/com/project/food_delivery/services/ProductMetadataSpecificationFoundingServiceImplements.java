package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.models.ProductMetadata;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMetadataSpecificationFoundingServiceImplements implements ProductMetadataSpecificationFoundingService{
    private final ProductMetadataSpecificationBuildingService productMetadataSpecificationBuildingService;
    @Override
    public Specification<ProductMetadata> returnProductSpecificationFromMemoryData(ProductMemoryValueData productMemoryValueData) {
        Specification<ProductMetadata> spec = Specification.where(null);

        if (productMemoryValueData.getName() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByName(productMemoryValueData.getName()));
        }

        if (productMemoryValueData.getProductCategory().getProductCategory() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByProductCategory(productMemoryValueData.getProductCategory().getProductCategory()));
        }

        if (productMemoryValueData.getPlace().getName() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPlaceName(productMemoryValueData.getPlace().getName()));
        }

        if (productMemoryValueData.getProductCharacteristic().getPrice() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPrice(productMemoryValueData.getProductCharacteristic().getPrice()));
        }

        if (productMemoryValueData.getProductCharacteristic().getWeight() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeight(productMemoryValueData.getProductCharacteristic().getWeight()));
        }

        if (productMemoryValueData.getProductCharacteristic().getAvailableAmount() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByAvailableAmount(productMemoryValueData.getProductCharacteristic().getAvailableAmount()));
        }

        if (productMemoryValueData.getProductCharacteristic().getWeightMeasurement() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeightMeasurement(productMemoryValueData.getProductCharacteristic().getWeightMeasurement()));
        }
        return spec;
    }

    @Override
    public Specification<ProductMetadata> returnProductSpecificationFromRequestData(ProductDataDto productData) {
        Specification<ProductMetadata> spec = Specification.where(null);

        if (productData.getName() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByName(productData.getName()));
        }

        if (productData.getCategory() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByProductCategory(productData.getCategory()));
        }

        if (productData.getPlace() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPlaceName(productData.getPlace()));
        }

        if (productData.getProductCharacteristic().getPrice() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByPrice(productData.getProductCharacteristic().getPrice()));
        }

        if (productData.getProductCharacteristic().getWeight() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeight(productData.getProductCharacteristic().getWeight()));
        }

        if (productData.getProductCharacteristic().getAvailableAmount() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByAvailableAmount(productData.getProductCharacteristic().getAvailableAmount()));
        }

        if (productData.getProductCharacteristic().getWeightMeasurement() != null) {
            spec = spec.and(productMetadataSpecificationBuildingService.filterByWeightMeasurement(productData.getProductCharacteristic().getWeightMeasurement()));
        }
        return spec;
    }
}
