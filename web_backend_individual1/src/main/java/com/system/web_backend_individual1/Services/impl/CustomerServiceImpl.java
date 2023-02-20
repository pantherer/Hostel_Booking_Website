package com.system.web_backend_individual1.Services.impl;
import com.system.web_backend_individual1.Entity.Customer;
import com.system.web_backend_individual1.Pojo.CustomerPojo;
import com.system.web_backend_individual1.Repo.CustomerRepo;
import com.system.web_backend_individual1.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    public final CustomerRepo customerRepo;
    @Override
    public String save_customer(CustomerPojo customerPojo) {
       Customer customer  = new Customer();
       customer.setFullname(customerPojo.getFullname());
       customer.setPhone(customerPojo.getPhone());
       customer.setRoom_type(customerPojo.getRoom_type());
       customer.setCheck_in(customerPojo.getCheck_in());
       customer.setCheck_out(customerPojo.getCheck_out());
       customerRepo.save(customer);
       return "created";
    }

    @Override
    public List<Customer> fetchAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.customerRepo.deleteById(id);
    }
}
