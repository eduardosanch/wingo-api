package com.wingo.api.product.entity;

import com.wingo.api.category.entity.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 500)
    private String description;

    private Double price;

    @Builder.Default
    private Boolean available = true;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
