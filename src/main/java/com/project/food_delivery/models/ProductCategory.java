package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "product_categories")
@RequiredArgsConstructor
public class ProductCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_category")
    private String productCategory;

    @OneToOne
    @JoinColumn(name = "category_description_id", referencedColumnName = "id")
    private ProductCategoryDescription productCategoryDescription;
}
