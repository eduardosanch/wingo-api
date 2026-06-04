package com.wingo.api.user.controller;

import com.wingo.api.user.entity.User;
import com.wingo.api.user.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                userService.getUser(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user
    ) {

        return ResponseEntity.ok(
                userService.updateUser(id, user)
        );
    }
}