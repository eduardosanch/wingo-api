package com.wingo.api.auth.service;

import com.wingo.api.auth.dto.LoginRequest;
import com.wingo.api.auth.dto.RegisterRequest;
import com.wingo.api.user.entity.User;
import com.wingo.api.user.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException(
                    "Ya existe un usuario con ese correo"
            );
        }

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .phone(request.phone())
                .password(request.password())
                .points(0)
                .createdAt(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }

    public User login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Correo o contraseña incorrectos"
                        ));

        if (!user.getPassword().equals(request.password())) {
            throw new IllegalArgumentException(
                    "Correo o contraseña incorrectos"
            );
        }

        return user;
    }
}