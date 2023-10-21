package com.project.food_delivery.repositories;

import com.project.food_delivery.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductMetadata, Integer> ,
        JpaSpecificationExecutor<ProductMetadata> {
    List<ProductMetadata> findAllByProductCategory_ProductCategory(String category);
}
