package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDTO;

public interface CompanyService {
    void addNewCompanyIfNotExist(CompanyDTO companyDTO);
}
