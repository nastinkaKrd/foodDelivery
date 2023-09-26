package com.project.food_delivery.dtos;

import com.project.food_delivery.models.Payment;
import com.project.food_delivery.models.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {
    private LocalDateTime dateAndTime;
    private Float price;
    private Payment payment;
    private Status status;
}
