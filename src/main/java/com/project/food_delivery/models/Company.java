package com.project.food_delivery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "companies")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "companies")
    @ToString.Exclude
    private List<ProductMetadata> productMetadata;
}
