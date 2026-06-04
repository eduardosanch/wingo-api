package com.wingo.api.order.service;

import com.wingo.api.branch.entity.Branch;
import com.wingo.api.branch.repository.BranchRepository;
import com.wingo.api.order.dto.OrderItemRequest;
import com.wingo.api.order.dto.OrderRequest;
import com.wingo.api.order.entity.CustomerOrder;
import com.wingo.api.order.entity.OrderItem;
import com.wingo.api.order.repository.OrderItemRepository;
import com.wingo.api.order.repository.OrderRepository;
import com.wingo.api.product.entity.Product;
import com.wingo.api.product.repository.ProductRepository;
import com.wingo.api.user.entity.User;
import com.wingo.api.user.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;

    public OrderService(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            UserRepository userRepository,
            BranchRepository branchRepository,
            ProductRepository productRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public CustomerOrder createOrder(OrderRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario no encontrado"));

        Branch branch = branchRepository.findById(request.branchId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Sucursal no encontrada"));

        double total = 0;

        for (OrderItemRequest item : request.items()) {

            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Producto no encontrado"));

            total += product.getPrice() * item.quantity();
        }

        CustomerOrder order = CustomerOrder.builder()
                .user(user)
                .branch(branch)
                .total(total)
                .status("PENDIENTE")
                .createdAt(LocalDateTime.now())
                .build();

        CustomerOrder savedOrder = orderRepository.save(order);

        for (OrderItemRequest item : request.items()) {

            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Producto no encontrado"));

            OrderItem orderItem = OrderItem.builder()
                    .order(savedOrder)
                    .product(product)
                    .quantity(item.quantity())
                    .unitPrice(product.getPrice())
                    .build();

            orderItemRepository.save(orderItem);
        }

        return savedOrder;
    }

    public List<CustomerOrder> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public CustomerOrder getOrder(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido no encontrado"));
    }
}