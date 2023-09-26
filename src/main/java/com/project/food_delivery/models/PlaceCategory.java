package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place_categories")
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class PlaceCategory {
    public PlaceCategory(String placeCategory) {
        this.placeCategory = placeCategory;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "place_category")
    private String placeCategory;

}
