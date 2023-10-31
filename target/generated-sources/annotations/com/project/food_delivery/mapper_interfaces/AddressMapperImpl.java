package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.models.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T15:20:24+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address addressDtoToModel(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setCity( addressDto.getCity() );
        address.setStreet( addressDto.getStreet() );
        address.setBuildingNum( addressDto.getBuildingNum() );

        return address;
    }

    @Override
    public AddressDto addressToDto(Address address) {
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
}
