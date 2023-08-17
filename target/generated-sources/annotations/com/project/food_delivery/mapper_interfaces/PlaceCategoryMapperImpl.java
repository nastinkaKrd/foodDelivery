package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.models.PlaceCategory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T15:05:07+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class PlaceCategoryMapperImpl implements PlaceCategoryMapper {

    @Override
    public PlaceCategoryDto placeCategoryToPlaceCategoryDto(PlaceCategory placeCategory) {
        if ( placeCategory == null ) {
            return null;
        }

        PlaceCategoryDto placeCategoryDto = new PlaceCategoryDto();

        placeCategoryDto.setPlaceCategory( placeCategory.getPlaceCategory() );

        return placeCategoryDto;
    }
}
