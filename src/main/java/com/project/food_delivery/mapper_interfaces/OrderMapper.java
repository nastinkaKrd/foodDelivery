package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto orderToDto(Order order);

}
