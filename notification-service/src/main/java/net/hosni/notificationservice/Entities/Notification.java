package net.hosni.notificationservice.Entities;

import jakarta.persistence.*;
import lombok.*;
import net.hosni.notificationservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDate createdAt;

    @Transient
    private Customer customer;

    private Long customerId;
}
