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
    public AddressDto changeAddress(Address address) {
        addressRepository.save(address);
        return addressMapper.addressToDto(addressRepository.findById(address.getId()).get());
    }

    @Override
    public Address addNewAddressAndReturn(AddressDto addressDTO) {
        Address addressModel = addressMapper.addressDtoToModel(addressDTO);
        return addressRepository.findByCityAndStreetAndBuildingNum(addressDTO.getCity(),
                addressDTO.getStreet(), addressDTO.getBuildingNum()).orElseGet(
                () ->{
                    addressRepository.save(addressModel);
                    return addressRepository.findByCityAndStreetAndBuildingNum(addressDTO.getCity(),
                            addressDTO.getStreet(), addressDTO.getBuildingNum()).get();
                }
        );
    }
}
