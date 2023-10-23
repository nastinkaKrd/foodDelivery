package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.UserInformationDto;
import com.project.food_delivery.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserInformationDto userToDto(User user);
}
