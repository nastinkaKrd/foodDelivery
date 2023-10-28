package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.dtos.ProductCharacteristicDto;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.models.Company;
import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.models.ProductCharacteristic;
import com.project.food_delivery.models.ProductMetadata;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T11:45:01+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class ProductMetadataMapperImpl implements ProductMetadataMapper {

    @Override
    public ProductMetadataDto productMetadataToDto(ProductMetadata productMetadata) {
        if ( productMetadata == null ) {
            return null;
        }

        ProductMetadataDto productMetadataDto = new ProductMetadataDto();

        productMetadataDto.setName( productMetadata.getName() );
        productMetadataDto.setProductCategory( productCategoryToProductCategoryDto( productMetadata.getProductCategory() ) );
        productMetadataDto.setProductCharacteristic( productCharacteristicToProductCharacteristicDto( productMetadata.getProductCharacteristic() ) );
        productMetadataDto.setCompanies( companyListToCompanyDtoRequestList( productMetadata.getCompanies() ) );

        return productMetadataDto;
    }

    protected ProductCategoryDto productCategoryToProductCategoryDto(ProductCategory productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setProductCategory( productCategory.getProductCategory() );
        productCategoryDto.setProductCategoryDescription( productCategory.getProductCategoryDescription() );

        return productCategoryDto;
    }

    protected ProductCharacteristicDto productCharacteristicToProductCharacteristicDto(ProductCharacteristic productCharacteristic) {
        if ( productCharacteristic == null ) {
            return null;
        }

        ProductCharacteristicDto productCharacteristicDto = new ProductCharacteristicDto();

        productCharacteristicDto.setPrice( productCharacteristic.getPrice() );
        productCharacteristicDto.setWeight( productCharacteristic.getWeight() );
        productCharacteristicDto.setAvailableAmount( productCharacteristic.getAvailableAmount() );
        productCharacteristicDto.setWeightMeasurement( productCharacteristic.getWeightMeasurement() );

        return productCharacteristicDto;
    }

    protected CompanyDtoRequest companyToCompanyDtoRequest(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDtoRequest companyDtoRequest = new CompanyDtoRequest();

        companyDtoRequest.setName( company.getName() );

        return companyDtoRequest;
    }

    protected List<CompanyDtoRequest> companyListToCompanyDtoRequestList(List<Company> list) {
        if ( list == null ) {
            return null;
        }

        List<CompanyDtoRequest> list1 = new ArrayList<CompanyDtoRequest>( list.size() );
        for ( Company company : list ) {
            list1.add( companyToCompanyDtoRequest( company ) );
        }

        return list1;
    }
}
