package net.hosni.notificationservice;

import net.hosni.notificationservice.Entities.Notification;
import net.hosni.notificationservice.Repository.NotificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(NotificationRepository notificationRepository){
        return args -> {
            List<Notification> notificationList= List.of(
                    Notification.builder()
                                .content("we are solved problem of database")
                                .createdAt(LocalDate.now())
                                .customerId(1L)
                                .build(),
                    Notification.builder()
                                .content("UI design is updated")
                                .createdAt(LocalDate.now())
                                .customerId(2L)
                                .build(),
                    Notification.builder()
                            .content("we will send u more servers soon")
                            .createdAt(LocalDate.now())
                            .customerId(3L)
                            .build(),
                    Notification.builder()
                            .content("we are solved problem of database")
                            .createdAt(LocalDate.now())
                            .customerId(4L)
                            .build(),
                    Notification.builder()
                            .content("UI design is updated")
                            .createdAt(LocalDate.now())
                            .customerId(5L)
                            .build(),
                    Notification.builder()
                            .content("we will send u more servers soon")
                            .createdAt(LocalDate.now())
                            .customerId(6L)
                            .build(),
                    Notification.builder()
                            .content("UI design is updated")
                            .createdAt(LocalDate.now())
                            .customerId(7L)
                            .build(),
                    Notification.builder()
                            .content("we will send u more servers soon")
                            .createdAt(LocalDate.now())
                            .customerId(8L)
                            .build()
            );
            notificationRepository.saveAll(notificationList);
        };
    }

}
