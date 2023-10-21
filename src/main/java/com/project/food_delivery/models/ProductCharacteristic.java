package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_characteristics")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ProductCharacteristic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price")
    private Double price;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "available_amount")
    private Integer availableAmount;

    @Column(name = "weight_measurement")
    @Enumerated(EnumType.STRING)
    private WeightMeasurement weightMeasurement;

    @OneToOne(mappedBy = "productCharacteristic")
    private ProductMetadata productMetadata;
}
