package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.mapper_interfaces.CompanyMapper;
import com.project.food_delivery.models.Company;
import com.project.food_delivery.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImplements implements CompanyService{
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    public Company addNewCompany(CompanyDtoRequest companyDtoRequest) {
        return companyRepository.findByName(companyDtoRequest.getName()).orElseGet(
                () -> companyRepository.save(companyMapper.companyDtoToModel(companyDtoRequest))
        );
    }
}
