package com.system.web_backend_individual1.Repo;

//import com.system.springboot4.entity.Customer;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.system.web_backend_individual1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Entity vitrw ko User
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

