package com.project.food_delivery.services;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.dtos.ProductMemoryValueData;
import com.project.food_delivery.exceptions.ApiRequestExceptionNotFound;
import com.project.food_delivery.mapper_interfaces.OrderMapper;
import com.project.food_delivery.models.Order;
import com.project.food_delivery.models.Payment;
import com.project.food_delivery.models.ProductMetadata;
import com.project.food_delivery.models.Status;
import com.project.food_delivery.models.User;
import com.project.food_delivery.repositories.OrderRepository;
import com.project.food_delivery.repositories.ProductRedisRepository;
import com.project.food_delivery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class OrderServiceImplements implements OrderService{
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderMapper orderMapper;
    private final ProductRedisRepository productRedisRepository;
    private final ProductMetadataSpecificationFoundingService productMetadataSpecificationFoundingService;
    private final ProductRepository productRepository;

    @Override
    public List<OrderDto> getOrders(String username) {
        User user = userService.getUserByUsername(username);
        if (orderRepository.findOrdersByUser(user).isEmpty()){
            throw new ApiRequestExceptionNotFound("You don't have orders");
        }
        return orderRepository.findOrdersByUser(user).stream().map(orderMapper::orderToDto).toList();
    }


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

    @Override
    public void buildNewOrderFromBasket(String username, String payment) {
        List<ProductMemoryValueData> productMemoryValueData = productRedisRepository.findAll();
        AtomicReference<Double> price= new AtomicReference<>((double) 0);
        List<ProductMetadata> productMetadata = new ArrayList<>();
        productMemoryValueData.forEach(productMemoryValueData1 -> {
            if (productMemoryValueData1.getAmount() > 1){
                for (int i = 0; i < productMemoryValueData1.getAmount(); i++){
                    price.updateAndGet(v -> v + productMemoryValueData1.getProductCharacteristic().getPrice());
                }
            }else {
                price.updateAndGet(v -> v + productMemoryValueData1.getProductCharacteristic().getPrice());
            }
            Specification<ProductMetadata> specification = productMetadataSpecificationFoundingService.returnProductSpecificationFromMemoryData(productMemoryValueData1);
            productMetadata.add(productRepository.findOne(specification).orElseThrow());
        });
        Order order = Order.builder()
                .payment(Payment.valueOf(payment.toUpperCase()))
                .dateAndTime(LocalDateTime.now())
                .user(userService.getUserByUsername(username))
                .price(price.get())
                .status(Status.FORMED)
                .productMetadata(productMetadata).build();
        orderRepository.save(order);
        productRedisRepository.deleteProductsFromMemory();
    }


}


