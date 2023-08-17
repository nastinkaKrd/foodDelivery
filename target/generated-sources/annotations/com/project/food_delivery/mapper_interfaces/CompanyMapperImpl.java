package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.models.Company;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T15:16:10+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public Company companyDtoToModel(CompanyDtoRequest companyDtoRequest) {
        if ( companyDtoRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setName( companyDtoRequest.getName() );

        return company;
    }
}
