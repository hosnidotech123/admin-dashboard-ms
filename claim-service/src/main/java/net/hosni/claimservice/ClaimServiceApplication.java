package net.hosni.claimservice;

import net.hosni.claimservice.Entities.Claim;
import net.hosni.claimservice.Repository.ClaimRepository;
import net.hosni.claimservice.enums.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ClaimServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClaimServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ClaimRepository claimRepository){
        return args -> {
            Claim claim1= Claim.builder()
                    .content("database turned off")
                    .createdAt(LocalDate.now())
                    .customerId(Long.valueOf(1))
                    .status(Status.PENDING)
                    .build();
            Claim claim2= Claim.builder()
                    .content("server doesnt work")
                    .createdAt(LocalDate.now())
                    .customerId(Long.valueOf(2))
                    .status(Status.DONE)
                    .build();
            claimRepository.save(claim1);
            claimRepository.save(claim2);
        };
    }

}
