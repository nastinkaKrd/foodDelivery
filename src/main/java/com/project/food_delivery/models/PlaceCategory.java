package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place_categories")
@ToString
@RequiredArgsConstructor
public class PlaceCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "place_category")
    @Enumerated(EnumType.STRING)
    private PlaceCategoryValues placeCategoryValues;

}
