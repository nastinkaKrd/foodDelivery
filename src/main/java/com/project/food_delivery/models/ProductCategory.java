package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_categories")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ProductCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_category")
    private String productCategory;

    public ProductCategory(String productCategory, ProductCategoryDescription productCategoryDescription) {
        this.productCategory = productCategory;
        this.productCategoryDescription = productCategoryDescription;
    }

    @OneToOne
    @JoinColumn(name = "category_description_id", referencedColumnName = "id")
    private ProductCategoryDescription productCategoryDescription;
}
