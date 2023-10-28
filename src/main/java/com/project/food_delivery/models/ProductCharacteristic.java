package com.project.food_delivery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

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
