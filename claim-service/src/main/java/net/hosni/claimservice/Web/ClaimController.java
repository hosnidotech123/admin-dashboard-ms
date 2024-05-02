package net.hosni.claimservice.Web;


import net.hosni.claimservice.Entities.Claim;
import net.hosni.claimservice.Repository.ClaimRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaimController {

    private ClaimRepository claimRepository;

    public ClaimController(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }


    @GetMapping("/claims")
    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }

    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable Long id){
        return  claimRepository.findById(id).get();
    }
}
