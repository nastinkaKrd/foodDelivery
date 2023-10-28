package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionAlreadyReported;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.ProductMetadataMapper;
import com.project.food_delivery.models.*;
import com.project.food_delivery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImplements implements ProductService{
    private final ProductRepository productRepository;
    private final CompanyService companyService;
    private final ProductCharacteristicService productCharacteristicService;
    private final ProductMetadataMapper productMetadataMapper;
    private final ProductCategoryService productCategoryService;
    private final PlaceService placeService;
    private final ProductMetadataSpecificationFoundingService productMetadataSpecificationFoundingService;

    @Override
    public List<ProductMetadataDto> findProductInformationByProductCategory(String category) {
        List<ProductMetadata> productMetadata = productRepository.findAllByProductCategory_ProductCategory(category);
        if (productMetadata.isEmpty()){
            throw new ApiRequestExceptionNotFound("Requested data is not found");
        }
        return productMetadata.stream().map(productMetadataMapper::productMetadataToDto).toList();
    }

    @Override
    public void addProduct(ProductDataDto productData) {
        Specification<ProductMetadata> specification = productMetadataSpecificationFoundingService.findAndReturnProductMetadataSpecification(productData.getName(), productData.getCategory(), productData.getPlace(), productData.getProductCharacteristic().getPrice(),
                productData.getProductCharacteristic().getWeight(), productData.getProductCharacteristic().getAvailableAmount(), productData.getProductCharacteristic().getWeightMeasurement());
        Optional<ProductMetadata> productMetadata = productRepository.findOne(specification);
        CompanyDtoRequest companyDtoRequest = new CompanyDtoRequest();
        companyDtoRequest.setName(productData.getCompany());
        Company company = companyService.addNewCompany(companyDtoRequest);
        if (productMetadata.isPresent() && productMetadata.get().getCompanies().contains(company)){
            throw new ApiRequestExceptionAlreadyReported("This data already exists");
        }else {
            ProductCategory productCategory = productCategoryService.returnProductCategoryIfExists(productData.getCategory());
            Place place = placeService.returnPlaceIfExists(productData.getPlace());
            ProductCharacteristic productCharacteristic = productCharacteristicService.addProductCharacteristic(productData.getProductCharacteristic());
            ProductMetadata productMetadataModel = ProductMetadata.builder()
                    .name(productData.getName())
                    .productCategory(productCategory)
                    .place(place)
                    .productCharacteristic(productCharacteristic)
                    .companies(new ArrayList<>(List.of(company))).build();
            productRepository.save(productMetadataModel);
        }
    }
}
