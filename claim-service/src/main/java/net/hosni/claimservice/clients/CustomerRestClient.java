package net.hosni.claimservice.clients;

import net.hosni.claimservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {


    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> getAllCustomers();
}
