package com.project.food_delivery.services;

import com.project.food_delivery.dtos.PlaceDataDto;
import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionAlreadyReported;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.PlaceMapper;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.Place;
import com.project.food_delivery.models.PlaceCategory;
import com.project.food_delivery.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceServiceImplements implements PlaceService{
    private final PlaceRepository placeRepository;
    private final PlaceCategoryService placeCategoryService;
    private final AddressService addressService;
    private final PlaceMapper placeMapper;

    @Override
    public List<PlaceDto> getPlacesByPlaceCategory(String category) {
        List<Place> places = placeRepository.findAllByPlaceCategoryPlaceCategory(category);
        List<PlaceDto> placeDtos;
        if (!places.isEmpty()){
            placeDtos = places.stream().map(placeMapper::placeToDto).toList();
        }else {
            throw new ApiRequestExceptionNotFound("There aren't found places by this category");
        }
        return placeDtos;
    }

    @Override
    public void addPlace(PlaceDataDto placeData) {
        Optional<Place> placeFromDatabase = placeRepository.findByName(placeData.getName());
        if (placeFromDatabase.isEmpty() || !Objects.equals(placeFromDatabase.get().getPlaceCategory().getPlaceCategory(), placeData.getPlaceCategory())){
            AddressDto address = placeData.getAddress();
            PlaceCategory placeCategoryModel = placeCategoryService.addPlaceCategoryAndReturn(placeData.getPlaceCategory());
            Address addressModel = addressService.addNewAddress(address);
            Place place = Place.builder()
                    .name(placeData.getName())
                    .placeCategory(placeCategoryModel)
                    .addresses(new ArrayList<>(List.of(addressModel))).build();
            placeRepository.save(place);
        }else {
            throw new ApiRequestExceptionAlreadyReported("This place was added before");
        }
    }

    @Override
    public Place returnPlaceIfExists(String place) {
        return placeRepository.findByName(place).orElseThrow(
                () -> new ApiRequestExceptionNotFound("Place is not found, create it")
        );
    }

    @Override
    public List<PlaceDto> getPlacesByCity(String city) {
        List<Place> places = placeRepository.findAll();
        if (!places.isEmpty()){
            List<PlaceDto> placeDtoList = new ArrayList<>();
            places.forEach(place -> place.getAddresses().forEach(address -> {
                if (address.getCity().equals(city)){
                    placeDtoList.add(placeMapper.placeToDto(place));
                }
            }));
            if (placeDtoList.isEmpty()){
                throw new ApiRequestExceptionNotFound("In this city we don't do food delivery");
            }
            return placeDtoList;
        }else {
            throw new ApiRequestExceptionNotFound("Places is not found");
        }
    }
}
