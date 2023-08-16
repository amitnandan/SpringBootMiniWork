package com.transaction.Transaction.controller;

import com.transaction.Transaction.dto.OrderRequest;
import com.transaction.Transaction.dto.OrderResponse;
import com.transaction.Transaction.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder( @RequestBody OrderRequest orderRequest){

        return ResponseEntity.ok(orderService.placeOrder(orderRequest));

    }
}
