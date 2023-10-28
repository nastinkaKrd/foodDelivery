package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.models.Company;

public interface CompanyService {
    Company addNewCompany(CompanyDtoRequest companyDtoRequest);
}
