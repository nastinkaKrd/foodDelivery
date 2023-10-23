package com.project.food_delivery.services;

import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.models.WeightMeasurement;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductMetadataSpecificationBuildingServiceImplements implements ProductMetadataSpecificationBuildingService{
    public Specification<ProductMetadata> filterByName(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }
    public Specification<ProductMetadata> filterByProductCategory(String category){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("productCategory").get("productCategory"), category);
    }
    public Specification<ProductMetadata> filterByPlaceName(String placeName){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("place").get("name"), placeName);
    }
    public Specification<ProductMetadata> filterByPrice(Double price){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("productCharacteristic").get("price"), price);
    }
    public Specification<ProductMetadata> filterByWeight(Double weight){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("productCharacteristic").get("weight"), weight);
    }
    public Specification<ProductMetadata> filterByAvailableAmount(Integer availableAmount){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("productCharacteristic").get("availableAmount"), availableAmount);
    }
    public Specification<ProductMetadata> filterByWeightMeasurement(WeightMeasurement weightMeasurement){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("productCharacteristic").get("weightMeasurement"), weightMeasurement);
    }
}
