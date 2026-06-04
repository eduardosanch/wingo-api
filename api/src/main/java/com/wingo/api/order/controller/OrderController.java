package com.wingo.api.order.controller;

import com.wingo.api.order.dto.OrderRequest;
import com.wingo.api.order.entity.CustomerOrder;
import com.wingo.api.order.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(
            @Valid @RequestBody OrderRequest request
    ) {

        return ResponseEntity.ok(
                orderService.createOrder(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getOrder(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                orderService.getOrder(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CustomerOrder>> getUserOrders(
            @PathVariable Long userId
    ) {

        return ResponseEntity.ok(
                orderService.getOrdersByUser(userId)
        );
    }
}