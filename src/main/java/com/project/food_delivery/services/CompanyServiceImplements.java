package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.mapper_interfaces.CompanyMapper;
import com.project.food_delivery.models.Company;
import com.project.food_delivery.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImplements implements CompanyService{
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    public Company addNewCompanyIfNotExistAndReturned(CompanyDtoRequest companyDtoRequest) {
        Optional<Company> company = companyRepository.findByName(companyDtoRequest.getName());
        if (company.isEmpty()){
            companyRepository.save(companyMapper.companyDTOToModel(companyDtoRequest));
            return companyRepository.findByName(companyDtoRequest.getName()).get();
        }else {
            return company.get();
        }
    }
}
