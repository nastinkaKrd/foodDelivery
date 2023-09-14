package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;


@Entity
@Table(name = "product_metadata")
@Data
public class ProductMetadata {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToOne
    @JoinColumn(name = "product_characteristics_id", referencedColumnName = "id")
    private ProductCharacteristic productCharacteristic;

}
