package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDTO;
import com.project.food_delivery.dtos.ProductJoinCompanyDTO;
import com.project.food_delivery.dtos.ProductMetadataDTO;
import com.project.food_delivery.mapper_interfaces.CompanyMapper;
import com.project.food_delivery.mapper_interfaces.ProductJoinCompanyMapper;
import com.project.food_delivery.mapper_interfaces.ProductMetadataMapper;
import com.project.food_delivery.models.ProductsJoinCompanies;
import com.project.food_delivery.repositories.ProductJoinCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductJoinCompanyServiceImplements implements ProductJoinCompanyService{
    private final ProductJoinCompanyRepository productJoinCompanyRepository;
    private final ProductJoinCompanyMapper productJoinCompanyMapper;
    private final ProductMetadataMapper productMetadataMapper;
    private final CompanyMapper companyMapper;
    @Override
    public List<ProductJoinCompanyDTO> findProductInformationByProductCategory(String category) {
        List<ProductsJoinCompanies> productsJoinCompanies = productJoinCompanyRepository.findAllByProductMetadata_ProductCategory_ProductCategory(category);
        return productsJoinCompanies.stream().map(productJoinCompanyMapper::productJoinCompanyToDTO).toList();
    }

    @Override
    public void addNewInformation(CompanyDTO companyDTO, ProductMetadataDTO productMetadataDTO) {
        productJoinCompanyRepository.save(new ProductsJoinCompanies(
                productMetadataMapper.productMetadataToModel(productMetadataDTO),
                companyMapper.companyDTOToModel(companyDTO)));
    }

    @Override
    public boolean isDataExists(CompanyDTO companyDTO, ProductMetadataDTO productMetadataDTO) {
        List<ProductsJoinCompanies> productsJoinCompanies = productJoinCompanyRepository
                .findAllByProductMetadata(productMetadataMapper.productMetadataToModel(productMetadataDTO));
        boolean isFound = false;
        for (ProductsJoinCompanies temp: productsJoinCompanies){
            if (companyMapper.companyToDTO(temp.getCompany()) == companyDTO){
                isFound = true;
                break;
            }
        }
        return isFound;
    }
}
