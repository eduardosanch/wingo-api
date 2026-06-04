package com.wingo.api.user.service;

import com.wingo.api.user.entity.User;
import com.wingo.api.user.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Usuario no encontrado"
                        ));
    }

    public User updateUser(Long id, User updatedUser) {

        User user = getUser(id);

        user.setName(updatedUser.getName());
        user.setPhone(updatedUser.getPhone());

        return userRepository.save(user);
    }
}