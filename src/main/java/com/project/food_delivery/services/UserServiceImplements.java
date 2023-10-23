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
    public AddressDto changeUserAddressByUsername(String username, AddressDto address) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ApiRequestExceptionNotFound("User is not found"));
        List<Address> addresses = user.getAddresses();
        Optional<Address> addressOptional = addresses.stream().filter(addressTemp -> addressTemp.getId().equals(address.getId())).findFirst();
        Address addressModel = addressOptional.orElseThrow(
                () -> new ApiRequestExceptionNotFound("Address is not found")
        );
        addresses.remove(addressModel);
        Address addressReturned = addressService.changeAddress(address);
        addresses.add(addressReturned);
        return addressMapper.addressToDto(addressReturned);
    }


    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ApiRequestExceptionNotFound("User is not found")
        );
    }

    @Override
    public void deleteUserAccount(String username) {
        userRepository.findByUsername(username).ifPresentOrElse(
                user -> userRepository.deleteByUsername(user.getUsername()),
                () -> {
                    throw new ApiRequestExceptionNotFound("User is not found");
                }
        );
    }


    @Override
    public void addUserAddressByUsername(String username, AddressDto addressDTO) {
        userRepository.findByUsername(username).ifPresentOrElse(
                user -> {
                    Address address = addressService.addNewAddress(addressDTO);
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
