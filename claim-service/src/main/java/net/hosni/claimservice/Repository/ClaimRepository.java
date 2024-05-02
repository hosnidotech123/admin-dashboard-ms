package net.hosni.claimservice.Repository;

import net.hosni.claimservice.Entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Long> {
}
