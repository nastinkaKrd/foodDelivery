package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.AddressMapper;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImplements implements AddressService{
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Override
    public void deleteAddressById(Integer id) {
        addressRepository.findById(id).ifPresentOrElse(address -> addressRepository.deleteById(id),
                () -> {
            throw new  ApiRequestExceptionNotFound("This address not found");
        });
    }

    @Override
    public Address changeAddress(AddressDto addressDto) {
        return addressRepository.save(addressMapper.addressDtoToModel(addressDto));
    }

    @Override
    public Address addNewAddress(AddressDto addressDto) {
        Address addressModel = addressMapper.addressDtoToModel(addressDto);
        return addressRepository.findByCityAndStreetAndBuildingNum(addressDto.getCity(),
                addressDto.getStreet(), addressDto.getBuildingNum()).orElseGet(
                () -> addressRepository.save(addressModel)
        );
    }
}
