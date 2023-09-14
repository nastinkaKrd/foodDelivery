package com.project.food_delivery.services;

import com.project.food_delivery.models.Basket;
import com.project.food_delivery.models.Order;
import com.project.food_delivery.models.User;
import com.project.food_delivery.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImplements implements OrderService{
    OrderRepository orderRepository;
    UserServiceImplements userServiceImplements;
    @Override
    public List<Order> getListOfOrdersByUsername(String username) {
        User user = userServiceImplements.getUserByUsername(username);
        return orderRepository.findOrdersByUser(user);
    }

    @Override
    public void buildNewOrderFromBasket(Basket basket) {

    }
}
