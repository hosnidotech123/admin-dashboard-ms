package net.hosni.customerservice;

import net.hosni.customerservice.Entities.Customer;
import net.hosni.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList=List.of(
                    Customer.builder()
                            .username("Lina Hagerty")
                            .company("Rex company")
                            .contact("0607080904")
                            .email("lina.hagerty@gmail.com")
                            .image("https://plus.unsplash.com/premium_photo-1688350839154-1a131bccd78a?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build(),
                    Customer.builder()
                            .username("John Doe")
                            .company("ABC Corporation")
                            .contact("0712345678")
                            .email("john.doe@example.com")
                            .image("https://images.unsplash.com/photo-1500648767791-00dcc994a43e?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build()

            );
            customerRepository.saveAll(customerList);
        };
    }

}
