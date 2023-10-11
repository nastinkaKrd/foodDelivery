package com.project.food_delivery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name = "product_metadata")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ProductMetadata {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @ManyToMany( cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "products_join_companies",
    joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "company_id", referencedColumnName = "id")
    })
    private List<Company> companies;

    @OneToOne( cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "product_metadata_join_characteristics",
        joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "characteristics_id", referencedColumnName = "id")
        }
    )
    private ProductCharacteristic productCharacteristic;

    public ProductMetadata(String name, ProductCategory productCategory, ProductCharacteristic productCharacteristic, Place place, List<Company> companies) {
        this.name = name;
        this.productCategory = productCategory;
        this.productCharacteristic = productCharacteristic;
        this.place = place;
        this.companies = companies;
    }

    @JsonBackReference
    @ManyToMany(mappedBy = "productMetadata")
    @ToString.Exclude
    private List<Order> orders;

}
