package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.CompanyDTO;
import com.project.food_delivery.dtos.ProductJoinCompanyDTO;
import com.project.food_delivery.dtos.ProductMetadataDTO;
import com.project.food_delivery.models.ProductsJoinCompanies;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProductMetadataDTO.class, CompanyDTO.class})
public interface ProductJoinCompanyMapper {
    ProductJoinCompanyDTO productJoinCompanyToDTO(ProductsJoinCompanies productsJoinCompanies);
    ProductsJoinCompanies productJoinCompanyDTOToModel(ProductJoinCompanyDTO productJoinCompanyDTO);
}
