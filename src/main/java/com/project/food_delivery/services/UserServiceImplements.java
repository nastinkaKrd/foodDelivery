package com.project.food_delivery.services;

import com.project.food_delivery.dtos.AddressDto;
import com.project.food_delivery.dtos.UserInformationDto;
import com.project.food_delivery.dtos.UsernameAndAddressDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.AddressMapper;
import com.project.food_delivery.mapper_interfaces.UserMapper;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.User;
import com.project.food_delivery.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplements implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final AddressService addressService;
    @Override
    public UserInformationDto findUserInformationByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new ApiRequestExceptionNotFound("Information is not found");
        }
        return userMapper.userToDto(user.get());
    }

    @Override
    public AddressDto changeUserAddressByUsername(String username, AddressDto address, Integer address_id) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            List<Address> addresses = user.get().getAddresses();
            boolean isFound = false;
            int index = 0;
            for (Address address1: addresses){
                if (Objects.equals(address1.getId(), address_id)){
                    isFound = true;
                    break;
                }
                index++;
            }
            if (isFound){
                Address addressModel = addressMapper.addressDTOToModel(address);
                addressModel.setId(address_id);
                addresses.add(index, addressModel);
                AddressDto addressDto = addressService.changeAddress(addressModel);
                User userModel = user.get();
                userModel.setAddresses(addresses);
                userRepository.save(userModel);
                return addressDto;
            }else {
                throw new ApiRequestExceptionNotFound("Address is not found");
            }
        }else {
            throw new ApiRequestExceptionNotFound("User is not found");
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new ApiRequestExceptionNotFound("User is not found");
        }
        return user.get();
    }

    @Override
    public void deleteUserAccount(String username) {
        if (isUserExists(username)){
            userRepository.deleteByUsername(username);
        }else {
            throw new ApiRequestExceptionNotFound("User is not found");
        }
    }

    @Override
    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void addUserAddressByUsername(String username, AddressDto addressDTO) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            Address address = addressService.addNewAddressAndReturn(addressDTO);
            User userModel = user.get();
            List<Address> addresses = userModel.getAddresses();
            addresses.add(address);
            userModel.setAddresses(addresses);
            userRepository.save(userModel);
        }else {
            throw new ApiRequestExceptionNotFound("User is not found");
        }
    }

    @Override
    public void deleteUserAddressByUsername(UsernameAndAddressDto usernameAndAddress) {
        Optional<User> user = userRepository.findByUsername(usernameAndAddress.getUsername());
        if (user.isPresent()){
            User userModel = user.get();
            List<Address> address = user.get().getAddresses();
            for (Address addressTemp: address){
                if (addressTemp.getId().equals(usernameAndAddress.getAddressId())){
                    address.remove(addressTemp);
                    break;
                }
            }
            userModel.setAddresses(address);
            userRepository.save(userModel);
            addressService.deleteAddressById(usernameAndAddress.getAddressId());
        }else {
            throw new ApiRequestExceptionNotFound("User or address is not found");
        }
    }
}
