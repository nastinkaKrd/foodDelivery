package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.ProductData;
import com.project.food_delivery.dtos.CompanyDTO;
import com.project.food_delivery.dtos.ProductMetadataDTO;
import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImplements implements ProductService{
    private final ProductRepository productRepository;
    private final CompanyService companyService;
    private final ProductJoinCompanyService productJoinCompanyService;
    @Override
    public void addProduct(ProductData productData) {
        CompanyDTO companyDTO = new CompanyDTO(productData.getCompany());
        ProductMetadataDTO productMetadataDTO = productData.getProductMetadataDTO();
        boolean isFound = productJoinCompanyService.isDataExists(companyDTO, productMetadataDTO);
        if (!isFound){
            productRepository.save(new ProductMetadata());
            companyService.addNewCompanyIfNotExist(companyDTO);
            productJoinCompanyService.addNewInformation(companyDTO, productMetadataDTO);
        }
    }
}
