package com.project.food_delivery.mapper_interfaces;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.models.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T15:16:10+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto orderToDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setDateAndTime( order.getDateAndTime() );
        orderDto.setPrice( order.getPrice() );
        orderDto.setPayment( order.getPayment() );
        orderDto.setStatus( order.getStatus() );

        return orderDto;
    }
}
