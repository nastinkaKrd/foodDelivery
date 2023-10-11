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
