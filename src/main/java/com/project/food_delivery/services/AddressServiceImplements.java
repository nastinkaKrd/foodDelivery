package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDTO;
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
    public void addNewAddress(AddressDTO addressDTO) {
        Address address = addressMapper.addressDTOToModel(addressDTO);
        if (addressRepository.findByCityAndStreetAndBuildingNum(addressDTO.getCity(),
                addressDTO.getStreet(), addressDTO.getBuildingNum()).isEmpty()){
            addressRepository.save(address);
        }else {
            //will be handler exception
        }
    }

    @Override
    public void deleteAddressById(Integer id) {
        if (addressRepository.findById(id).isPresent()){
            addressRepository.deleteById(id);
        }else {
            //will be handler exception
        }
    }
}
