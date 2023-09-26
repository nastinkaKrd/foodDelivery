package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_characteristics")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ProductCharacteristic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price")
    private Float price;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "available_amount")
    private Integer availableAmount;

    @Column(name = "weight_measurement")
    @Enumerated(EnumType.STRING)
    private WeightMeasurement weightMeasurement;
}
