package com.project.food_delivery.dtos;

import com.project.food_delivery.models.Payment;
import com.project.food_delivery.models.Status;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {
    private LocalDateTime dateAndTime;
    private Double price;
    private Payment payment;
    private Status status;
    private List<ProductMetadataDto> productMetadata;
}
