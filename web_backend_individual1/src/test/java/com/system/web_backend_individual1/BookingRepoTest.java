package com.system.web_backend_individual1;
import com.system.web_backend_individual1.Entity.Customer;
import com.system.web_backend_individual1.Repo.CustomerRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BookingRepoTest {
    @Autowired
    private CustomerRepo customerRepo;
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCustomerTest(){
        Customer customer = Customer.builder()
                .fullname("Amul Bashyal").build();

        customerRepo.save(customer);

        Assertions.assertThat(customer.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getCustomerTest(){
        Customer customerCreated=customerRepo.findById(1).get();
        Assertions.assertThat(customerCreated.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void getListOfCustomerTest(){
        List<Customer> Customers = customerRepo.findAll();
        Assertions.assertThat(Customers.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCustomerTest(){
        Customer customer =customerRepo.findById(1).get();
        customer.setFullname("Abhyash Adhikari");
        Customer customerUpdated = customerRepo.save(customer);
        Assertions.assertThat(customerUpdated.getFullname()).isEqualTo("Abhyash Adhikari");
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteCustomerTest(){
        Customer customer = customerRepo.findById(1).get();
        customerRepo.delete(customer);
        Customer customer1 = null;
        Optional<Customer> optionalCustomer = customerRepo.findCustomerByFullname("Abhyash Adhikari");
        if(optionalCustomer.isPresent()){
            customer1 = optionalCustomer.get();
        }
        Assertions.assertThat(customer1).isNull();
    }

}
