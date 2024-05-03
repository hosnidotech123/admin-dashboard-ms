package net.hosni.claimservice.Web;


import net.hosni.claimservice.Entities.Claim;
import net.hosni.claimservice.Repository.ClaimRepository;
import net.hosni.claimservice.clients.CustomerRestClient;
import net.hosni.claimservice.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaimController {

    private ClaimRepository claimRepository;

    private CustomerRestClient customerRestClient;

    public ClaimController(ClaimRepository claimRepository, CustomerRestClient customerRestClient) {
        this.claimRepository = claimRepository;
        this.customerRestClient = customerRestClient;
    }


    @GetMapping("/claims")
    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }

    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable Long id){

        Claim claim=claimRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(claim.getCustomerId());
        claim.setCustomer(customer);

        return claim ;
    }
}
