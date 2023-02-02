package com.system.web_backend_individual1.Repo;
import com.system.web_backend_individual1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByFullname(String fullname);
}

