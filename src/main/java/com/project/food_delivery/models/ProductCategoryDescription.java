package com.project.food_delivery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Entity
@Table(name = "product_categories_descriptions")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ProductCategoryDescription {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

     public ProductCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Column(name = "category_description")
    private String categoryDescription;
}
