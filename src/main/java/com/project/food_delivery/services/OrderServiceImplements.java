package com.project.food_delivery.services;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.OrderMapper;
import com.project.food_delivery.models.Order;
import com.project.food_delivery.models.Status;
import com.project.food_delivery.models.User;
import com.project.food_delivery.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImplements implements OrderService{
    private final OrderRepository orderRepository;
    private final UserServiceImplements userServiceImplements;
    private final OrderMapper orderMapper;
    @Override
    public List<OrderDto> getListOfOrdersByUsername(String username) {
        User user = userServiceImplements.getUserByUsername(username);
        if (orderRepository.findOrdersByUser(user).isEmpty()){
            throw new ApiRequestExceptionNotFound("You don't have orders");
        }
        return orderRepository.findOrdersByUser(user).stream().map(orderMapper::orderToDto).toList();
    }

   /* @Override
    public void buildNewOrderFromBasket(Basket basket) {

    }*/

    @Override
    public String changeOrderStatus(String status, String orderId) {
        Integer id = Integer.parseInt(orderId);
        List<Status> stringStatuses = Arrays.stream(Status.values()).toList();
        if (stringStatuses.contains(Status.valueOf(status.toUpperCase())) && orderRepository.findById(id).isPresent()){
            Order order = orderRepository.findById(id).get();
            order.setStatus(Status.valueOf(status.toUpperCase()));
            orderRepository.save(order);
            return orderRepository.findById(id).get().getStatus().toString();
        }else {
            throw new ApiRequestExceptionNotFound("This order is not found or you wrote not right status (Please check it)");
        }
    }
}
