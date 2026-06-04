package com.wingo.api.order.entity;

import com.wingo.api.product.entity.Product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}