package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "places_join_product_categories")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class PlacesJoinProductCategories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;
}
