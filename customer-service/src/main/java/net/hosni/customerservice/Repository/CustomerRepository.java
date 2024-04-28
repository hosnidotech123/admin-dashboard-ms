package net.hosni.customerservice.Repository;

import net.hosni.customerservice.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
