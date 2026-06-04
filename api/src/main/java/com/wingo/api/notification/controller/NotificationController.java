package com.wingo.api.notification.controller;

import com.wingo.api.notification.entity.Notification;
import com.wingo.api.notification.service.NotificationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService
    ) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications() {

        return ResponseEntity.ok(
                notificationService.getAllNotifications()
        );
    }
}