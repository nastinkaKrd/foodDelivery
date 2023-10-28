package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCategoryDto;
import com.project.food_delivery.models.ProductCategory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T11:45:01+0300",
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
        productCategoryDto.setProductCategoryDescription( productCategory.getProductCategoryDescription() );

        return productCategoryDto;
    }
}
