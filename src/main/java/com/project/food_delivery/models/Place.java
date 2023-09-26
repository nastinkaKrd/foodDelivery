package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "places")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Place(String name, PlaceCategory placeCategory) {
        this.name = name;
        this.placeCategory = placeCategory;
    }

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "place_category_id", referencedColumnName = "id")
    private PlaceCategory placeCategory;
}
