package net.hosni.customerservice.Web;


import net.hosni.customerservice.Entities.Customer;
import net.hosni.customerservice.Repository.CustomerRepository;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

    @PatchMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id , @RequestBody Map<String,Object> fields){
        Customer customer =customerRepository.findById(id).get();

        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Customer.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,customer,value);
        });

        return customerRepository.save(customer);

    }

}
