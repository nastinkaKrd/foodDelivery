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
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ApiRequestExceptionNotFound("Information is not found")
        );
        return userMapper.userToDto(user);
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
                Address addressModel = addressMapper.addressDtoToModel(address);
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
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ApiRequestExceptionNotFound("User is not found")
        );
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
        userRepository.findByUsername(username).ifPresentOrElse(
                user -> {
                    Address address = addressService.addNewAddressAndReturn(addressDTO);
                    List<Address> addresses = user.getAddresses();
                    addresses.add(address);
                    user.setAddresses(addresses);
                    userRepository.save(user);
                },
                () -> {
                    throw new ApiRequestExceptionNotFound("User is not found");
                }
        );
    }

    @Override
    public void deleteUserAddressByUsername(UsernameAndAddressDto usernameAndAddress) {
        userRepository.findByUsername(usernameAndAddress.getUsername()).ifPresentOrElse(
                user -> {
                    List<Address> address = user.getAddresses();
                    for (Address addressTemp: address){
                        if (addressTemp.getId().equals(usernameAndAddress.getAddressId())){
                            address.remove(addressTemp);
                            break;
                        }
                    }
                    user.setAddresses(address);
                    userRepository.save(user);
                    addressService.deleteAddressById(usernameAndAddress.getAddressId());
                },
                () -> {
                    throw new ApiRequestExceptionNotFound("User or address is not found");
                }
        );
    }
}
