package com.project.food_delivery.dtos;

import com.project.food_delivery.models.WeightMeasurement;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;
import java.util.Objects;

@Data
@Builder
public class ProductMemoryKeyData {
    private String name;
    private List<CompanyDtoRequest> companies;
    private PlaceDto place;
    private Double price;
    private Double weight;
    private Integer availableAmount;
    private WeightMeasurement weightMeasurement;


    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companies, place, price, weight, availableAmount, weightMeasurement);
    }
}
