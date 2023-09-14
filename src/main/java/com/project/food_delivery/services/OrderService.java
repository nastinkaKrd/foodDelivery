package com.project.food_delivery.services;

import com.project.food_delivery.models.Basket;
import com.project.food_delivery.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getListOfOrdersByUsername(String username);

    void buildNewOrderFromBasket(Basket basket);
}
