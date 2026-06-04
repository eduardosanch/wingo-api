package com.wingo.api.config;

import com.wingo.api.notification.entity.Notification;
import com.wingo.api.notification.repository.NotificationRepository;
import com.wingo.api.reward.entity.Reward;
import com.wingo.api.reward.repository.RewardRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RewardRepository rewardRepository;
    private final NotificationRepository notificationRepository;

    @Override
    public void run(String... args) {

        loadRewards();
        loadNotifications();
    }

    private void loadRewards() {

        if (rewardRepository.count() > 0) {
            return;
        }

        rewardRepository.save(
                Reward.builder()
                        .title("Papas Gratis")
                        .description("Canjea unas papas gratis en tu siguiente compra.")
                        .requiredPoints(100)
                        .build()
        );

        rewardRepository.save(
                Reward.builder()
                        .title("Refresco Gratis")
                        .description("Obtén un refresco gratis al acumular puntos.")
                        .requiredPoints(250)
                        .build()
        );

        rewardRepository.save(
                Reward.builder()
                        .title("Combo Gratis")
                        .description("Canjea un combo especial completamente gratis.")
                        .requiredPoints(500)
                        .build()
        );
    }

    private void loadNotifications() {

        if (notificationRepository.count() > 0) {
            return;
        }

        notificationRepository.save(
                Notification.builder()
                        .title("¡Bienvenido a Wing'O!")
                        .message("Gracias por descargar nuestra aplicación.")
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        notificationRepository.save(
                Notification.builder()
                        .title("Programa Rewards")
                        .message("Acumula puntos en cada pedido y canjéalos por recompensas.")
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        notificationRepository.save(
                Notification.builder()
                        .title("Promoción Especial")
                        .message("Consulta nuestros combos y promociones disponibles.")
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}