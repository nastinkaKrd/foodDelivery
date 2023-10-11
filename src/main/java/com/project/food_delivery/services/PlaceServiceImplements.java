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
        List<PlaceDto> placeDTOS;
        if (!places.isEmpty()){
            placeDTOS = places.stream().map(placeMapper::placeToDTO).toList();
        }else {
            throw new ApiRequestExceptionNotFound("There aren't found places by this category");
        }
        return placeDTOS;
    }

    @Override
    public void addPlace(PlaceDataDto placeData) {
        Optional<Place> placeFromDatabase = placeRepository.findByName(placeData.getName());
        if (placeFromDatabase.isEmpty() || !Objects.equals(placeFromDatabase.get().getPlaceCategory().getPlaceCategory(), placeData.getPlaceCategory())){
            AddressDto address = placeData.getAddress();
            PlaceCategory placeCategoryModel = placeCategoryService.addPlaceCategoryAndReturn(placeData.getPlaceCategory());
            Address addressModel = addressService.addNewAddressAndReturn(address);
            Place place = new Place(placeData.getName(), placeCategoryModel, new ArrayList<>(List.of(addressModel)));
            placeRepository.save(place);
        }else {
            throw new ApiRequestExceptionAlreadyReported("This place was added before");
        }
    }

    @Override
    public Place returnPlaceIfExists(String place) {
        Optional<Place> placeOptional = placeRepository.findByName(place);
        if (placeOptional.isEmpty()){
            throw new ApiRequestExceptionNotFound("Place is not found, create it");
        }
        return placeOptional.get();
    }

    @Override
    public List<PlaceDto> getPlacesByCity(String city) {
        List<Place> places = placeRepository.findAll();
        if (!places.isEmpty()){
            List<PlaceDto> placeDtos = new ArrayList<>();
            places.forEach(place -> place.getAddresses().forEach(address -> {
                if (address.getCity().equals(city)){
                    placeDtos.add(placeMapper.placeToDTO(place));
                }
            }));
            if (placeDtos.isEmpty()){
                throw new ApiRequestExceptionNotFound("In this city we don't do food delivery");
            }
            return placeDtos;
        }else {
            throw new ApiRequestExceptionNotFound("Places is not found");
        }
    }
}
