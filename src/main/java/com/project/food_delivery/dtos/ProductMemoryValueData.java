package com.project.food_delivery.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@RedisHash("Product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductMemoryValueData implements Serializable {
    private String name;
    private ProductCategoryDto productCategory;
    private ProductCharacteristicDto productCharacteristic;
    private List<CompanyDtoRequest> companies;
    private PlaceDto place;
    private Integer amount;
}
