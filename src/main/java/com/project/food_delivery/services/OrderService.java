package com.project.food_delivery.services;

import com.project.food_delivery.dtos.OrderDto;
import java.util.List;

public interface OrderService {
    List<OrderDto> getListOfOrdersByUsername(String username);

    //void buildNewOrderFromBasket(Basket basket);
    String changeOrderStatus(String status, String orderId);
}
