package com.wingo.api.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequest(

        @NotNull(message = "El usuario es obligatorio")
        Long userId,

        @NotNull(message = "La sucursal es obligatoria")
        Long branchId,

        @Valid
        @NotEmpty(message = "El pedido debe contener productos")
        List<OrderItemRequest> items

) {
}