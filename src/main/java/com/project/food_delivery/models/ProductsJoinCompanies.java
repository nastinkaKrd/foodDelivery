package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products_join_companies")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ProductsJoinCompanies {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductMetadata productMetadata;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public ProductsJoinCompanies(ProductMetadata productMetadata, Company company) {
        this.productMetadata = productMetadata;
        this.company = company;
    }
}
