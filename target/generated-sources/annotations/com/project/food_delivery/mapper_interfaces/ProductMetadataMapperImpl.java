package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.dtos.ProductCategoryDescriptionDto;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.dtos.ProductCharacteristicDto;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.Company;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.models.PlaceCategory;
import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.models.ProductCategoryDescription;
import com.project.food_delivery.models.ProductCharacteristic;
import com.project.food_delivery.models.ProductMetadata;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T11:37:59+0200",
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
        productMetadataDto.setPlace( placeToPlaceDto( productMetadata.getPlace() ) );

        return productMetadataDto;
    }

    protected ProductCategoryDescriptionDto productCategoryDescriptionToProductCategoryDescriptionDto(ProductCategoryDescription productCategoryDescription) {
        if ( productCategoryDescription == null ) {
            return null;
        }

        ProductCategoryDescriptionDto productCategoryDescriptionDto = new ProductCategoryDescriptionDto();

        productCategoryDescriptionDto.setCategoryDescription( productCategoryDescription.getCategoryDescription() );

        return productCategoryDescriptionDto;
    }

    protected ProductCategoryDto productCategoryToProductCategoryDto(ProductCategory productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setProductCategory( productCategory.getProductCategory() );
        productCategoryDto.setProductCategoryDescription( productCategoryDescriptionToProductCategoryDescriptionDto( productCategory.getProductCategoryDescription() ) );

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

    protected PlaceCategoryDto placeCategoryToPlaceCategoryDto(PlaceCategory placeCategory) {
        if ( placeCategory == null ) {
            return null;
        }

        PlaceCategoryDto placeCategoryDto = new PlaceCategoryDto();

        placeCategoryDto.setPlaceCategory( placeCategory.getPlaceCategory() );

        return placeCategoryDto;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setCity( address.getCity() );
        addressDto.setStreet( address.getStreet() );
        addressDto.setBuildingNum( address.getBuildingNum() );

        return addressDto;
    }

    protected List<AddressDto> addressListToAddressDtoList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDto> list1 = new ArrayList<AddressDto>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressDto( address ) );
        }

        return list1;
    }

    protected PlaceDto placeToPlaceDto(Place place) {
        if ( place == null ) {
            return null;
        }

        PlaceDto placeDto = new PlaceDto();

        placeDto.setName( place.getName() );
        placeDto.setPlaceCategory( placeCategoryToPlaceCategoryDto( place.getPlaceCategory() ) );
        placeDto.setAddresses( addressListToAddressDtoList( place.getAddresses() ) );

        return placeDto;
    }
}
