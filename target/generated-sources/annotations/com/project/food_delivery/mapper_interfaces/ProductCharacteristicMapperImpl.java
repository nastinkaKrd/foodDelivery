package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.ProductCharacteristicDto;
import com.project.food_delivery.models.ProductCharacteristic;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T15:20:24+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class ProductCharacteristicMapperImpl implements ProductCharacteristicMapper {

    @Override
    public ProductCharacteristic productCharacteristicDtoToModel(ProductCharacteristicDto productCharacteristicDto) {
        if ( productCharacteristicDto == null ) {
            return null;
        }

        ProductCharacteristic productCharacteristic = new ProductCharacteristic();

        productCharacteristic.setPrice( productCharacteristicDto.getPrice() );
        productCharacteristic.setWeight( productCharacteristicDto.getWeight() );
        productCharacteristic.setAvailableAmount( productCharacteristicDto.getAvailableAmount() );
        productCharacteristic.setWeightMeasurement( productCharacteristicDto.getWeightMeasurement() );

        return productCharacteristic;
    }
}
