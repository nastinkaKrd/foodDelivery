package com.project.food_delivery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;
import java.util.List;


@Entity
@Table(name = "product_metadata")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
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

    @JsonBackReference
    @ManyToMany(mappedBy = "productMetadata")
    @ToString.Exclude
    private List<Order> orders;

}
