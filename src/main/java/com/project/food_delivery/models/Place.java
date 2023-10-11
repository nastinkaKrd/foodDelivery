package com.project.food_delivery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import java.util.List;

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

    public Place(String name, PlaceCategory placeCategory, List<Address> addresses) {
        this.name = name;
        this.placeCategory = placeCategory;
        this.addresses = addresses;
    }

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "place_category_id", referencedColumnName = "id")
    private PlaceCategory placeCategory;

    @ManyToMany( cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "places_join_addresses",
            joinColumns = {
                    @JoinColumn(name = "place_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "addres_id", referencedColumnName = "id")
            })
    private List<Address> addresses;

    @ManyToMany( cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "places_join_product_categories",
            joinColumns = {
                    @JoinColumn(name = "place_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
            })
    private List<ProductCategory> productCategories;
}
