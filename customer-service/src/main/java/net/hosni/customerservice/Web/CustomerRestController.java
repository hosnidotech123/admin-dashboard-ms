package net.hosni.customerservice.Web;


import net.hosni.customerservice.Entities.Customer;
import net.hosni.customerservice.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerRestController {


    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

}
