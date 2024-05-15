package net.hosni.claimservice;

import net.hosni.claimservice.Entities.Claim;
import net.hosni.claimservice.Repository.ClaimRepository;
import net.hosni.claimservice.enums.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ClaimServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClaimServiceApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(ClaimRepository claimRepository){
//        return args -> {
//            Claim claim1= Claim.builder()
//                    .content("database turned off")
//                    .createdAt(LocalDate.now())
//                    .customerId(Long.valueOf(1))
//                    .status(Status.PENDING)
//                    .build();
//            Claim claim2= Claim.builder()
//                    .content("server doesnt work")
//                    .createdAt(LocalDate.now())
//                    .customerId(Long.valueOf(2))
//                    .status(Status.DONE)
//                    .build();
//            claimRepository.save(claim1);
//            claimRepository.save(claim2);
//        };
//    }

    @Bean
    CommandLineRunner commandLineRunner(ClaimRepository claimRepository) {
        return args -> {
            List<Claim> claimList = List.of(
                    Claim.builder()
                            .content("server doesnt work")
                            .createdAt(LocalDate.now())
                            .customerId(1L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("need more servers")
                            .createdAt(LocalDate.now())
                            .customerId(2L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("client app crashes frequently")
                            .createdAt(LocalDate.now())
                            .customerId(3L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("database connection error")
                            .createdAt(LocalDate.now())
                            .customerId(4L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("network latency issues")
                            .createdAt(LocalDate.now())
                            .customerId(5L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("update UI design")
                            .createdAt(LocalDate.now())
                            .customerId(6L)
                            .status("done")
                            .build(),

                    Claim.builder()
                            .content("API endpoint not working")
                            .createdAt(LocalDate.now())
                            .customerId(7L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("missing authentication feature")
                            .createdAt(LocalDate.now())
                            .customerId(8L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("frontend not responsive")
                            .createdAt(LocalDate.now())
                            .customerId(3L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("slow database queries")
                            .createdAt(LocalDate.now())
                            .customerId(4L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("security vulnerability found")
                            .createdAt(LocalDate.now())
                            .customerId(5L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("outdated software version")
                            .createdAt(LocalDate.now())
                            .customerId(6L)
                            .status("done")
                            .build(),

                    Claim.builder()
                            .content("payment gateway integration issue")
                            .createdAt(LocalDate.now())
                            .customerId(1L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("missing error handling")
                            .createdAt(LocalDate.now())
                            .customerId(2L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("data synchronization problem")
                            .createdAt(LocalDate.now())
                            .customerId(3L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("expired SSL certificate")
                            .createdAt(LocalDate.now())
                            .customerId(4L)
                            .status("pending")
                            .build(),
                    Claim.builder()
                            .content("broken links on website")
                            .createdAt(LocalDate.now())
                            .customerId(5L)
                            .status("done")
                            .build(),
                    Claim.builder()
                            .content("backend server timeout")
                            .createdAt(LocalDate.now())
                            .customerId(6L)
                            .status("done")
                            .build(),

                    Claim.builder()
                            .content("slow database queries")
                            .createdAt(LocalDate.now())
                            .customerId(3L)
                            .status("done")
                            .build()
            );

            claimRepository.saveAll(claimList);
        };
    }


//    @Bean
//    CommandLineRunner commandLineRunner(ClaimRepository claimRepository) {
//        return args -> {
//            List<Claim> claimList = List.of(
//                    Claim.builder()
//                            .content("server doesnt work")
//                            .createdAt(LocalDate.now())
//                            .customerId(1L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("need more servers")
//                            .createdAt(LocalDate.now())
//                            .customerId(2L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("client app crashes frequently")
//                            .createdAt(LocalDate.now())
//                            .customerId(3L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("database connection error")
//                            .createdAt(LocalDate.now())
//                            .customerId(4L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("network latency issues")
//                            .createdAt(LocalDate.now())
//                            .customerId(5L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("update UI design")
//                            .createdAt(LocalDate.now())
//                            .customerId(6L)
//                            .status(Status.DONE)
//                            .build(),
//
//                    Claim.builder()
//                            .content("API endpoint not working")
//                            .createdAt(LocalDate.now())
//                            .customerId(7L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("missing authentication feature")
//                            .createdAt(LocalDate.now())
//                            .customerId(8L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("frontend not responsive")
//                            .createdAt(LocalDate.now())
//                            .customerId(3L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("slow database queries")
//                            .createdAt(LocalDate.now())
//                            .customerId(4L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("security vulnerability found")
//                            .createdAt(LocalDate.now())
//                            .customerId(5L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("outdated software version")
//                            .createdAt(LocalDate.now())
//                            .customerId(6L)
//                            .status(Status.DONE)
//                            .build(),
//
//                    Claim.builder()
//                            .content("payment gateway integration issue")
//                            .createdAt(LocalDate.now())
//                            .customerId(1L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("missing error handling")
//                            .createdAt(LocalDate.now())
//                            .customerId(2L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("data synchronization problem")
//                            .createdAt(LocalDate.now())
//                            .customerId(3L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("expired SSL certificate")
//                            .createdAt(LocalDate.now())
//                            .customerId(4L)
//                            .status(Status.PENDING)
//                            .build(),
//                    Claim.builder()
//                            .content("broken links on website")
//                            .createdAt(LocalDate.now())
//                            .customerId(5L)
//                            .status(Status.DONE)
//                            .build(),
//                    Claim.builder()
//                            .content("backend server timeout")
//                            .createdAt(LocalDate.now())
//                            .customerId(6L)
//                            .status(Status.DONE)
//                            .build(),
//
//                    Claim.builder()
//                            .content("slow database queries")
//                            .createdAt(LocalDate.now())
//                            .customerId(3L)
//                            .status(Status.DONE)
//                            .build()
//            );
//
//            claimRepository.saveAll(claimList);
//        };
//    }

}
