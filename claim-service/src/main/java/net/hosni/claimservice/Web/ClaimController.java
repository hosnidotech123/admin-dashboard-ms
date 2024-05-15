package net.hosni.claimservice.Web;


import net.hosni.claimservice.Entities.Claim;
import net.hosni.claimservice.Repository.ClaimRepository;
import net.hosni.claimservice.clients.CustomerRestClient;
import net.hosni.claimservice.enums.Status;
import net.hosni.claimservice.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ClaimController {

    private ClaimRepository claimRepository;

    private CustomerRestClient customerRestClient;



    public ClaimController(ClaimRepository claimRepository, CustomerRestClient customerRestClient) {
        this.claimRepository = claimRepository;
        this.customerRestClient = customerRestClient;

    }


    @GetMapping("/claims")
    public List<Claim> getAllClaims(){

        List<Claim> claimList=claimRepository.findAll();

        claimList.forEach(claim -> {
            claim.setCustomer(customerRestClient.getCustomerById(claim.getCustomerId()));
        });

        return claimList;
    }

    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable Long id){

        Claim claim=claimRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(claim.getCustomerId());
        claim.setCustomer(customer);

        return claim ;
    }

    @PostMapping("/claims")
    public Claim addClaim(@RequestBody Claim claim){
        Customer customer=customerRestClient.getCustomerById(claim.getCustomerId());
        claim.setCustomer(customer);
        claim.setCreatedAt(LocalDate.now());
        return claimRepository.save(claim);
    }

    @PatchMapping("/claims/{id}")
    public Claim updateClaimState(@PathVariable Long id , @RequestBody Map<String,Object> fields){
        Claim claim =claimRepository.findById(id).get();

        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Claim.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,claim,value);
        });

        return claimRepository.save(claim);

    }




}

//    @PatchMapping("/employees/{id}/{firstName}")
//    public ResponseEntity<Employee> updateEmployeePartially(@PathVariable Long id, @PathVariable String firstName) {
//        try {
//            Employee employee = employeeRepository.findById(id).get();
//            employee.setFirstName(firstName);
//            return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
