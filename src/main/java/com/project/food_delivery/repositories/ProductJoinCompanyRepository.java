package com.project.food_delivery.repositories;

import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.models.ProductsJoinCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductJoinCompanyRepository extends JpaRepository<ProductsJoinCompanies, Integer> {
    List<ProductsJoinCompanies> findAllByProductMetadata_ProductCategory_ProductCategory(String productCategory);
    List<ProductsJoinCompanies> findAllByProductMetadata(ProductMetadata productMetadata);
}
