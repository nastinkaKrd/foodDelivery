package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.UserInformationDto;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T17:50:27+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserInformationDto userToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserInformationDto userInformationDto = new UserInformationDto();

        userInformationDto.setUsername( user.getUsername() );
        userInformationDto.setEmail( user.getEmail() );
        userInformationDto.setPhoneNumber( user.getPhoneNumber() );
        userInformationDto.setAddresses( addressListToAddressDtoList( user.getAddresses() ) );

        return userInformationDto;
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
