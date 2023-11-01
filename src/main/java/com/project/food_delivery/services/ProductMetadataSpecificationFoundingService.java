package com.project.food_delivery.services;

import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.models.ProductMetadata;
import org.springframework.data.jpa.domain.Specification;

public interface ProductMetadataSpecificationFoundingService {
    Specification<ProductMetadata> returnProductSpecificationFromMemoryData(ProductMemoryValueData productMemoryValueData);
    Specification<ProductMetadata> returnProductSpecificationFromRequestData(ProductDataDto productData);
}
