package net.hosni.claimservice.Entities;

import jakarta.persistence.*;
import lombok.*;
import net.hosni.claimservice.enums.Status;
import net.hosni.claimservice.model.Customer;

import java.time.LocalDate;


@Entity
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate createdAt;

    @Transient
    private Customer customer;

    private Long customerId;
}
