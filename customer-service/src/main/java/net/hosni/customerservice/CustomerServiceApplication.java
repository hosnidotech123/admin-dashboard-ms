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
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customerList = List.of(
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
                            .build(),
                    Customer.builder()
                            .username("Jane Smith")
                            .company("XYZ Inc.")
                            .contact("0723456789")
                            .email("jane.smith@example.com")
                            .image("https://plus.unsplash.com/premium_photo-1689539137236-b68e436248de?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build(),
                    Customer.builder()
                            .username("Alina Johnson")
                            .company("Tech Solutions")
                            .contact("0734567890")
                            .email("alina.johnson@example.com")
                            .image("https://images.unsplash.com/photo-1607746882042-944635dfe10e?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build(),
                    Customer.builder()
                            .username("Toa Williams")
                            .company("Global Services")
                            .contact("0745678901")
                            .email("toa.williams@example.com")
                            .image("https://images.unsplash.com/photo-1517841905240-472988babdf9?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build(),
                    Customer.builder()
                            .username("Eve Brown")
                            .company("Innovative Ideas")
                            .contact("0756789012")
                            .email("eve.brown@example.com")
                            .image("https://daisyui.com/tailwind-css-component-profile-2@56w.png")
                            .build(),
                    Customer.builder()
                            .username("Ola Williams")
                            .company("Tech Services")
                            .contact("0745678901")
                            .email("ola.williams@example.com")
                            .image("https://images.unsplash.com/photo-1580489944761-15a19d654956?q=80&w=1961&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build(),
                    Customer.builder()
                            .username("James Williams")
                            .company("IOT Services")
                            .contact("0745678901")
                            .email("james.williams@example.com")
                            .image("https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?q=80&w=1780&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    };
//    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
//        return args -> {
//            List<Customer> customerList=List.of(
//                    Customer.builder()
//                            .username("Lina Hagerty")
//                            .company("Rex company")
//                            .contact("0607080904")
//                            .email("lina.hagerty@gmail.com")
//                            .image("https://plus.unsplash.com/premium_photo-1688350839154-1a131bccd78a?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
//                            .build(),
//                    Customer.builder()
//                            .username("John Doe")
//                            .company("ABC Corporation")
//                            .contact("0712345678")
//                            .email("john.doe@example.com")
//                            .image("https://images.unsplash.com/photo-1500648767791-00dcc994a43e?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
//                            .build()
//
//            );
//            customerRepository.saveAll(customerList);
//        };
//    }

}
