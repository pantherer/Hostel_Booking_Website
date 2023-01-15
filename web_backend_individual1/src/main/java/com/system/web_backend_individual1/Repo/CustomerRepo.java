package com.system.web_backend_individual1.Repo;
import com.system.web_backend_individual1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

