package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDTO;
import com.project.food_delivery.dtos.ProductJoinCompanyDTO;
import com.project.food_delivery.dtos.ProductMetadataDTO;

import java.util.List;

public interface ProductJoinCompanyService {
    List<ProductJoinCompanyDTO> findProductInformationByProductCategory(String category);
    void addNewInformation(CompanyDTO companyDTO, ProductMetadataDTO productMetadataDTO);
    boolean isDataExists(CompanyDTO companyDTO, ProductMetadataDTO productMetadataDTO);
}
