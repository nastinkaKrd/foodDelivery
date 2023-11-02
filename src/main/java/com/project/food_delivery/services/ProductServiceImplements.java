package com.project.food_delivery.services;

import com.project.food_delivery.dtos.CompanyDtoRequest;
import com.project.food_delivery.dtos.ProductDataDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.dtos.ProductMetadataDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionAlreadyReported;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.ProductMetadataMapper;
import com.project.food_delivery.mapper_interfaces.RequestProductDataMapper;
import com.project.food_delivery.models.Company;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.models.ProductCharacteristic;
import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.repositories.ProductRedisRepository;
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
    private final ProductRedisRepository productRedisRepository;
    private final RequestProductDataMapper requestProductDataMapper;

    @Override
    public void saveProductInMemory(ProductMetadataDto productMetadata) {
        productRedisRepository.save(productMetadata);
    }

    @Override
    public List<ProductMemoryValueData> getAllProducts() {
        return productRedisRepository.findAll();
    }

    @Override
    public void addOneMoreProduct(ProductMetadataDto productMetadata) {
        productRedisRepository.addOneMoreProduct(productMetadata);
    }

    @Override
    public void deleteOneProduct(ProductMetadataDto productMetadata) {
        productRedisRepository.deleteOneProduct(productMetadata);
    }

    @Override
    public ProductMemoryValueData getProductByKey(ProductMetadataDto productMetadataDto) {
        return productRedisRepository.findByKey(productMetadataDto).orElseThrow(
                () -> new ApiRequestExceptionNotFound("Product is not found"));
    }

    @Override
    public void deleteProductFromMemory(ProductMetadataDto productMetadataDto) {
        productRedisRepository.deleteProduct(productMetadataDto);
    }

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
        Specification<ProductMetadata> specification = productMetadataSpecificationFoundingService.returnProductSpecification(requestProductDataMapper.convertRequestDataToFinding(productData));
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
