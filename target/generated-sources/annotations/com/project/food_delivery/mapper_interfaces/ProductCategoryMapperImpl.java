package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCategoryDescriptionDto;
import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.models.ProductCategory;
import com.project.food_delivery.models.ProductCategoryDescription;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T15:05:08+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class ProductCategoryMapperImpl implements ProductCategoryMapper {

    @Override
    public ProductCategoryDto productCategoryToDto(ProductCategory productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setProductCategory( productCategory.getProductCategory() );
        productCategoryDto.setProductCategoryDescription( productCategoryDescriptionToProductCategoryDescriptionDto( productCategory.getProductCategoryDescription() ) );

        return productCategoryDto;
    }

    protected ProductCategoryDescriptionDto productCategoryDescriptionToProductCategoryDescriptionDto(ProductCategoryDescription productCategoryDescription) {
        if ( productCategoryDescription == null ) {
            return null;
        }

        ProductCategoryDescriptionDto productCategoryDescriptionDto = new ProductCategoryDescriptionDto();

        productCategoryDescriptionDto.setCategoryDescription( productCategoryDescription.getCategoryDescription() );

        return productCategoryDescriptionDto;
    }
}
