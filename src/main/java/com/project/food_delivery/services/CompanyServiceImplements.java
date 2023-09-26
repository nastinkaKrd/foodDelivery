package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDTO;
import com.project.food_delivery.mapper_interfaces.CompanyMapper;
import com.project.food_delivery.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImplements implements CompanyService{
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    public void addNewCompanyIfNotExist(CompanyDTO companyDTO) {
        if (companyRepository.findByName(companyDTO.getName()).isEmpty()){
            companyRepository.save(companyMapper.companyDTOToModel(companyDTO));
        }
    }
}
