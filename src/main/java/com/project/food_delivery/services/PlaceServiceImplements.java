package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.PlaceData;
import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.dtos.PlaceDTO;
import com.project.food_delivery.dtos.PlaceJoinAddressDTO;
import com.project.food_delivery.mapper_interfaces.PlaceMapper;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.models.PlaceCategory;
import com.project.food_delivery.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceServiceImplements implements PlaceService{
    private final PlaceRepository placeRepository;
    private final PlaceCategoryService placeCategoryService;
    private final AddressService addressService;
    private final PlaceJoinAddressService placeJoinAddressService;
    private final PlaceMapper placeMapper;

    @Override
    public List<PlaceDTO> getPlacesByPlaceCategory(String category) {
        List<Place> places = placeRepository.findAllByPlaceCategoryPlaceCategory(category);
        List<PlaceDTO> placeDTOS = new ArrayList<>();
        if (!places.isEmpty()){
            placeDTOS = places.stream().map(placeMapper::placeToDTO).toList();
        }else {
            //will be handler exception
        }
        return placeDTOS;
    }

    @Override
    public List<PlaceDTO> getPlacesByCity(String city) {
        List<PlaceJoinAddressDTO> placeJoinAddressDTOS = placeJoinAddressService.findAllByCity(city);
        List<PlaceDTO> placeDTOS = new ArrayList<>();
        if (!placeJoinAddressDTOS.isEmpty()){
            placeDTOS = placeJoinAddressDTOS.stream().map(PlaceJoinAddressDTO::getPlace).toList();
        }else {
            //will be handler exception
        }
        return placeDTOS;
    }

    @Override
    public void addPlace(PlaceData placeData) {
        PlaceCategory placeCategory = new PlaceCategory(placeData.getPlaceCategory());
        Place place = new Place(placeData.getName(), placeCategory);
        AddressDTO address = placeData.getAddress();
        placeCategoryService.addPlaceCategory(placeData.getPlaceCategory());
        addressService.addNewAddress(address);
        Optional<Place> placeFromDatabase = placeRepository.findByName(placeData.getName());
        if (placeFromDatabase.isEmpty() || placeFromDatabase.get().getPlaceCategory() != placeCategory){
            placeRepository.save(place);
        }else {
            //will be handler exception
        }
        placeJoinAddressService.addNewData(address, placeMapper.placeToDTO(place));
    }
}
