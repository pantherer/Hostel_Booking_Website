package com.system.web_backend_individual1.Services;
import com.system.web_backend_individual1.Entity.Customer;
import com.system.web_backend_individual1.Pojo.CustomerPojo;

import java.util.List;

public interface CustomerService {

    String save_customer(CustomerPojo customerPojo);

    List<Customer> fetchAll();
}