package com.project.food_delivery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.*;

@Entity
@Table(name = "product_categories_descriptions")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class ProductCategoryDescription {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_description")
    private String categoryDescription;
}
