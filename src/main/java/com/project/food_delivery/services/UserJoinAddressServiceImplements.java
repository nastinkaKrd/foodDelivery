package com.project.food_delivery.services;

import com.project.food_delivery.RequestBodies.UsernameAndAddress;
import com.project.food_delivery.dtos.AddressDTO;
import com.project.food_delivery.mapper_interfaces.AddressMapper;
import com.project.food_delivery.models.Address;
import com.project.food_delivery.models.User;
import com.project.food_delivery.models.UsersJoinAddresses;
import com.project.food_delivery.repositories.UserJoinAddressRepository;
import com.project.food_delivery.response_bodies.UserInformation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserJoinAddressServiceImplements implements UserJoinAddressService{
    private final UserJoinAddressRepository userJoinAddressRepository;
    private final AddressMapper addressMapper;
    private final UserService userService;
    private final AddressService addressService;
    @Override
    public UserInformation findUserInformationByUsername(String username) {
        List<UsersJoinAddresses> userJoinAddresses = userJoinAddressRepository.findAllByUser_Username(username);
        List<AddressDTO> addressDTOS = userJoinAddresses.stream()
                .map(usersJoinAddresses -> addressMapper.addressToDTO(usersJoinAddresses.getAddress())).toList();
        User user =  userJoinAddresses.get(0).getUser();
        return new UserInformation(user.getUsername(), user.getEmail(), user.getPhoneNumber(), addressDTOS);
    }

    @Override
    public AddressDTO changeUserAddressByUsername(String username, AddressDTO address, Integer address_id) {
        Optional<UsersJoinAddresses> usersJoinAddresses = userJoinAddressRepository
                .findByUser_UsernameAndAddress_Id(username, address_id);
        if (usersJoinAddresses.isPresent()){
            User user = userService.getUserByUsername(username);
            userJoinAddressRepository.save(new UsersJoinAddresses(usersJoinAddresses.get().getId(), user,
                    new Address(address_id, address.getCity(), address.getCity(), address.getBuildingNum())));
        }
        return addressMapper.addressToDTO(
                userJoinAddressRepository.findByUser_UsernameAndAddress_Id(username, address_id).get().getAddress());
    }

    @Override
    public void addUserAddressByUsername(String username, AddressDTO addressDTO) {
        if (userService.isUserExists(username)){
            addressService.addNewAddress(addressDTO);
            userJoinAddressRepository.save(new UsersJoinAddresses(userService.getUserByUsername(username),
                    addressMapper.addressDTOToModel(addressDTO)));
        }

    }

    @Override
    public void deleteUserAddressByUsername(UsernameAndAddress usernameAndAddress) {
        if (userJoinAddressRepository.findByUser_UsernameAndAddress_Id(usernameAndAddress.getUsername(),
                usernameAndAddress.getAddress_id()).isPresent()){
            addressService.deleteAddressById(usernameAndAddress.getAddress_id());
        }
    }
}
