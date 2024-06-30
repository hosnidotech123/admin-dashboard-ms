package net.hosni.claimservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hosni.claimservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {


    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService",fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name="customerService",fallbackMethod = "getAllDefaultCustomer")
    List<Customer> getAllCustomers();


    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer= new Customer();
        customer.setId(id);
        customer.setUsername("not Found");
        customer.setEmail("not Found");
        customer.setImage("not Found");
        customer.setCompany("not Found");
        customer.setIsActivated("false");
        customer.setContact("not Found");

        return customer;

    }

    default List<Customer>  getAllDefaultCustomer(Exception exception){
        return List.of();
    }
}
