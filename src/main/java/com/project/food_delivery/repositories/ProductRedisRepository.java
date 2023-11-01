package com.project.food_delivery.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.food_delivery.dtos.ProductMemoryKeyData;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRedisRepository {
    public static final String HASH_KEY = "Product";
    private RedisTemplate<String, ProductMemoryValueData> template;

    public ProductMemoryValueData buildValueData(ProductMetadataDto productMetadata){
        return ProductMemoryValueData.builder()
                .name(productMetadata.getName())
                .productCategory(productMetadata.getProductCategory())
                .companies(productMetadata.getCompanies())
                .productCharacteristic(productMetadata.getProductCharacteristic())
                .place(productMetadata.getPlace())
                .amount(1).build();
    }

    public String buildKeyData(ProductMetadataDto productMetadata){
        return String.valueOf(
                ProductMemoryKeyData.builder()
                        .name(productMetadata.getName())
                        .companies(productMetadata.getCompanies())
                        .price(productMetadata.getProductCharacteristic().getPrice())
                        .weight(productMetadata.getProductCharacteristic().getWeight())
                        .availableAmount(productMetadata.getProductCharacteristic().getAvailableAmount())
                        .weightMeasurement(productMetadata.getProductCharacteristic().getWeightMeasurement())
                        .place(productMetadata.getPlace()).build().hashCode()
        );
    }

    public void save(ProductMetadataDto productMetadata){
        ProductMemoryValueData productMemoryValueData = buildValueData(productMetadata);
        String productMemoryKeyData = buildKeyData(productMetadata);
        template.opsForHash().put(HASH_KEY, productMemoryKeyData, productMemoryValueData);
    }

    public void addOneMoreProduct(ProductMetadataDto productMetadata){
        ProductMemoryValueData productMemoryValueData = buildValueData(productMetadata);
        String productMemoryKeyData = buildKeyData(productMetadata);
        findByKey(productMetadata).ifPresentOrElse(
                productMemoryValueData1 -> productMemoryValueData.setAmount(productMemoryValueData1.getAmount()+1),
                () -> {
                    throw new ApiRequestExceptionNotFound("Product is not found");
                });
        template.opsForHash().put(HASH_KEY, productMemoryKeyData, productMemoryValueData);
    }

    public void deleteOneProduct(ProductMetadataDto productMetadata){
        ProductMemoryValueData productMemoryValueData = buildValueData(productMetadata);
        String productMemoryKeyData = buildKeyData(productMetadata);
        findByKey(productMetadata).ifPresentOrElse(
                productMemoryValueData1 -> {
                    if (productMemoryValueData1.getAmount()-1 == 0){
                        template.opsForHash().delete(HASH_KEY, productMemoryKeyData);
                    }else {
                        productMemoryValueData.setAmount(productMemoryValueData1.getAmount()-1);
                        template.opsForHash().put(HASH_KEY, productMemoryKeyData, productMemoryValueData);
                    }
                },
                () -> {
                    throw new ApiRequestExceptionNotFound("Product is not found");
                });
    }

    public void deleteProductsFromMemory(){
        template.delete(Objects.requireNonNull(template.keys("*")));
    }
    public List<ProductMemoryValueData> findAll() {
        List<Object> productMetadataDtoList = template.opsForHash().values(HASH_KEY);
        if (productMetadataDtoList.isEmpty()){
            throw new ApiRequestExceptionNotFound("Products are not found");
        }else {
            List<ProductMemoryValueData> result = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            for (Object value : productMetadataDtoList) {
                if (value instanceof LinkedHashMap<?, ?> linkedHashMap) {
                    result.add(objectMapper.convertValue(linkedHashMap, ProductMemoryValueData.class));
                } else {
                    result.add((ProductMemoryValueData) value);
                }
            }
            return result;
        }
    }

    public Optional<ProductMemoryValueData> findByKey(ProductMetadataDto productMetadata) {
        String productMemoryKeyData = buildKeyData(productMetadata);
        Object result = template.opsForHash().get(HASH_KEY, productMemoryKeyData);
        System.out.println(result);
        if (result != null) {
            if (result instanceof LinkedHashMap<?, ?> linkedHashMap) {
                ObjectMapper objectMapper = new ObjectMapper();
                return Optional.of(objectMapper.convertValue(linkedHashMap, ProductMemoryValueData.class));
            } else if (result instanceof ProductMemoryValueData) {
                return Optional.of((ProductMemoryValueData) result);
            }
        }

        return Optional.empty();
    }

    public void deleteProduct(ProductMetadataDto productMetadata){
        String productMemoryKeyData = buildKeyData(productMetadata);
        findByKey(productMetadata).ifPresentOrElse(
                productMemoryValueData -> template.opsForHash().delete(HASH_KEY, productMemoryKeyData),
                () -> {
                    throw new ApiRequestExceptionNotFound("Product is not found");
                });
    }
}
