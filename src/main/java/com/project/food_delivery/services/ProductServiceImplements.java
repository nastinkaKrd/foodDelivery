package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionAlreadyReported;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.ProductCharacteristicMapper;
import com.project.food_delivery.mapper_interfaces.ProductMetadataMapper;
import com.project.food_delivery.models.*;
import com.project.food_delivery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
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
    private final ProductCharacteristicMapper productCharacteristicMapper;
    private final ProductMetadataMapper productMetadataMapper;
    private final ProductCategoryService productCategoryService;
    private final PlaceService placeService;

    @Override
    public List<ProductMetadataDto> findProductInformationByProductCategory(String category) {
        List<ProductMetadata> productMetadata = productRepository.findAllByProductCategory_ProductCategory(category);
        if (productMetadata.isEmpty()){
            throw new ApiRequestExceptionNotFound("Requested data is not found");
        }
        return productMetadata.stream().map(productMetadataMapper::productMetadataToDTO).toList();
    }

    @Override
    public void addProduct(ProductDataDto productData) {
        Optional<ProductMetadata> productMetadata = productRepository.
                findByNameAndProductCategory_ProductCategoryAndPlace_NameAndProductCharacteristic_PriceAndProductCharacteristic_WeightAndProductCharacteristic_AvailableAmountAndProductCharacteristic_WeightMeasurement
                        (productData.getName(), productData.getCategory(), productData.getPlace(), productData.getProductCharacteristic().getPrice(),
                                productData.getProductCharacteristic().getWeight(), productData.getProductCharacteristic().getAvailableAmount(), productData.getProductCharacteristic().getWeightMeasurement());
        Company company = companyService.addNewCompanyIfNotExistAndReturned(new CompanyDtoRequest(productData.getCompany()));
        if (productMetadata.isPresent() && productMetadata.get().getCompanies().contains(company)){
            throw new ApiRequestExceptionAlreadyReported("This data already exists");
        }else {
            ProductCategory productCategory = productCategoryService.returnProductCategoryIfExists(productData.getCategory());
            Place place = placeService.returnPlaceIfExists(productData.getPlace());
            ProductCharacteristic productCharacteristic = productCharacteristicService.addProductCharacteristicAndReturn(productData.getProductCharacteristic());
            ProductMetadata productMetadataModel = new ProductMetadata(productData.getName(), productCategory, productCharacteristic, place, new ArrayList<>(List.of(company)));
            productRepository.save(productMetadataModel);
        }
    }
}
