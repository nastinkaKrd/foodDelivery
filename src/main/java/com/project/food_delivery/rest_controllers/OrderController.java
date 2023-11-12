package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.OrderDto;
import com.project.food_delivery.services.OrderService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@OpenAPIDefinition(
        info = @Info(
                title = "Order Controller",
                version = "1.0",
                description = "Controller that processes users' orders"
        )
)
public class OrderController {
    private final OrderService orderService;

    @PutMapping("/{order-id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Change order status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order status changed", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", description = "Order is not found", content = @Content(mediaType = "text/plain"))
    })
    public String changeOrderStatus(@Parameter(description = "Order id", example = "0") @PathVariable(name = "order-id") String orderId,
                                    @Parameter(description = "Order status", example = "delivered") @RequestParam(name = "status") String status){
        return orderService.changeOrderStatus(status, orderId);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get user orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found orders",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderDto.class))}),
            @ApiResponse(responseCode = "404", description = "Orders are not found", content = @Content(mediaType = "text/plain"))
    })
    public List<OrderDto> getListOfOrdersByUsername(@Parameter(description = "Username", example = "nastinka_krd") @PathVariable(name = "username") String username){
        return orderService.getOrders(username);
    }

    @PostMapping("/{username}/{payment}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Build new order of products from basket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order is built", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", description = "Products are not found", content = @Content(mediaType = "text/plain"))
    })
    public void buildNewOrderFromBasket(@Parameter(description = "Username", example = "nastinka_krd") @PathVariable(name = "username") String username,
                                        @Parameter(description = "Payment", example = "cash") @PathVariable(name = "payment") String payment){
        orderService.buildNewOrderFromBasket(username, payment);
    }

}
