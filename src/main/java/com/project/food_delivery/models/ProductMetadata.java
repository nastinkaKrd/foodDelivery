package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "product_metadata")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
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
