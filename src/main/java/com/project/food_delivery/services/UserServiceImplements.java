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
import java.util.concurrent.atomic.AtomicInteger;

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
        List<com.project.food_delivery.models.Address> addresses = user.getAddresses();
        AtomicInteger index= new AtomicInteger(-1);
        boolean isFound = addresses.stream().anyMatch(addressModel -> {
            index.getAndIncrement();
            return addressModel.getId().equals(address.getId());
        });
        if (isFound){
            Address addressModel = addressService.changeAddress(address);
            addresses.add(index.get(), addressModel);
            user.setAddresses(addresses);
            userRepository.save(user);
            return addressMapper.addressToDto(addressModel);
        } else {
            throw new ApiRequestExceptionNotFound("Address is not found");
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
                    com.project.food_delivery.models.Address address = addressService.addNewAddress(addressDTO);
                    List<com.project.food_delivery.models.Address> addresses = user.getAddresses();
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
                    List<com.project.food_delivery.models.Address> address = user.getAddresses();
                    for (com.project.food_delivery.models.Address addressTemp: address){
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
