package com.project.food_delivery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "product_categories")
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "category_description_id", referencedColumnName = "id")
    private ProductCategoryDescription productCategoryDescription;

    @JsonBackReference
    @ManyToMany(mappedBy = "productCategories")
    @ToString.Exclude
    List<Place> places;
}
