package com.wingo.api.notification.service;

import com.wingo.api.notification.entity.Notification;
import com.wingo.api.notification.repository.NotificationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(
            NotificationRepository notificationRepository
    ) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}