package com.project.food_delivery.dtos;

import com.project.food_delivery.models.WeightMeasurement;
import lombok.Builder;
import lombok.Data;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMemoryKeyData that = (ProductMemoryKeyData) o;
        return Objects.equals(name, that.name) && Objects.equals(companies, that.companies) && Objects.equals(place, that.place) && Objects.equals(price, that.price) && Objects.equals(weight, that.weight) && Objects.equals(availableAmount, that.availableAmount) && weightMeasurement == that.weightMeasurement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companies, place, price, weight, availableAmount, weightMeasurement);
    }
}
