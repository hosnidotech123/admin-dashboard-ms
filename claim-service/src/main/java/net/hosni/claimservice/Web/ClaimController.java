package net.hosni.claimservice.Web;


import net.hosni.claimservice.Entities.Claim;
import net.hosni.claimservice.Repository.ClaimRepository;
import net.hosni.claimservice.clients.CustomerRestClient;
import net.hosni.claimservice.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
}
