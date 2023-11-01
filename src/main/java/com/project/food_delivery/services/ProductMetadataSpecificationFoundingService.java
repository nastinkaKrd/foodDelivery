package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductDataForFinding;
import com.project.food_delivery.models.ProductMetadata;
import org.springframework.data.jpa.domain.Specification;

public interface ProductMetadataSpecificationFoundingService {
    Specification<ProductMetadata> returnProductSpecification(ProductDataForFinding productDataForFinding);
}
