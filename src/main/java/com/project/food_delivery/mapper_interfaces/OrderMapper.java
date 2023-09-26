package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto orderToDto(Order order);

}
