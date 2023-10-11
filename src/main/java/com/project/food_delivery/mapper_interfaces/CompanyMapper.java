package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.models.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company companyDTOToModel(CompanyDtoRequest companyDtoRequest);
}
