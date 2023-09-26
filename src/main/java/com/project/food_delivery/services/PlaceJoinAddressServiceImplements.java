package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.dtos.PlaceDTO;
import com.project.food_delivery.dtos.PlaceJoinAddressDTO;
import com.project.food_delivery.mapper_interfaces.AddressMapper;
import com.project.food_delivery.mapper_interfaces.PlaceJoinAddressMapper;
import com.project.food_delivery.mapper_interfaces.PlaceMapper;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.models.PlacesJoinAddresses;
import com.project.food_delivery.repositories.PlaceJoinAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor
public class PlaceJoinAddressServiceImplements implements PlaceJoinAddressService{
    private final PlaceJoinAddressRepository placeJoinAddressRepository;
    private final PlaceMapper placeMapper;
    private final AddressMapper addressMapper;
    private final PlaceJoinAddressMapper placeJoinAddressMapper;
    @Override
    public void addNewData(AddressDTO addressDTO, PlaceDTO placeDTO) {
        Address address = addressMapper.addressDTOToModel(addressDTO);
        Place place = placeMapper.placeDTOToModel(placeDTO);
        List<PlacesJoinAddresses> placesJoinAddresses = placeJoinAddressRepository.findAllByAddress(address);
        AtomicBoolean isFound = new AtomicBoolean(false);
        placesJoinAddresses.forEach(placesJoinAddresses1 -> {
            if (placesJoinAddresses1.getPlace().getName().equals(place.getName())
            && placesJoinAddresses1.getPlace().getPlaceCategory().getPlaceCategory()
                    .equals(place.getPlaceCategory().getPlaceCategory())){
                isFound.set(true);
            }
        });
        if (!isFound.get()){
            placeJoinAddressRepository.save(new PlacesJoinAddresses(place, address));
        }
    }

    @Override
    public List<PlaceJoinAddressDTO> findAllByCity(String city) {
        List<PlacesJoinAddresses> placesJoinAddresses = placeJoinAddressRepository.findAllByAddress_City(city);
        if (!placesJoinAddresses.isEmpty()){
            return placesJoinAddresses.stream().map(placeJoinAddressMapper::placeJoinAddressToDTO).toList();
        }else {
            //will be handler exception
        }
        return placesJoinAddresses.stream().map(placeJoinAddressMapper::placeJoinAddressToDTO).toList();
    }
}
