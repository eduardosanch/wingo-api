package com.wingo.api.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Correo inválido")
        String email,

        @NotBlank(message = "El teléfono es obligatorio")
        String phone,

        @NotBlank(message = "La contraseña es obligatoria")
        String password

) {
}