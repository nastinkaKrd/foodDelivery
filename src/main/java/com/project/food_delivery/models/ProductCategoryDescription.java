package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

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
