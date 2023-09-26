package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.CompanyDTO;
import com.project.food_delivery.models.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO companyToDTO(Company company);
    Company companyDTOToModel(CompanyDTO companyDTO);
}
