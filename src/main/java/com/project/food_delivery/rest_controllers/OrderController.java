package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @PutMapping("/{order-id}")
    public String changeOrderStatus(@PathVariable(name = "order-id") String orderId, @RequestParam(name = "status") String status){
        return orderService.changeOrderStatus(status, orderId);
    }

    @GetMapping("/{username}")
    public List<OrderDto> getListOfOrdersByUsername(@PathVariable(name = "username") String username){
        return orderService.getOrders(username);
    }

    @PostMapping("/{username}/{payment}")
    public void buildNewOrderFromBasket(@PathVariable(name = "username") String username,
                                        @PathVariable(name = "payment") String payment){
        orderService.buildNewOrderFromBasket(username, payment);
    }

}
