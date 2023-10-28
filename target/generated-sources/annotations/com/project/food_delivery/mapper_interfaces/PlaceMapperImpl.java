package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.models.PlaceCategory;
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
public class PlaceMapperImpl implements PlaceMapper {

    @Override
    public PlaceDto placeToDto(Place place) {
        if ( place == null ) {
            return null;
        }

        PlaceDto placeDto = new PlaceDto();

        placeDto.setName( place.getName() );
        placeDto.setPlaceCategory( placeCategoryToPlaceCategoryDto( place.getPlaceCategory() ) );
        placeDto.setAddresses( addressListToAddressDtoList( place.getAddresses() ) );

        return placeDto;
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
}
