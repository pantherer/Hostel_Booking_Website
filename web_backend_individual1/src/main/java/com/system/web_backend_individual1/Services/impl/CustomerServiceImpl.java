package com.system.web_backend_individual1.Services.impl;

//import com.system.springboot4.entity.Customer;
//import com.system.springboot4.pojo.CustomerPojo;
//import com.system.springboot4.repo.CustomerRepo;
//import com.system.springboot4.services.CustomerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//
//public class CustomerServiceImpl implements CustomerService {
//    public final CustomerRepo customerRepoRepo;
////    public final BookingRepo bookingRepo;
//    @Override
//    public String save(CustomerPojo customerPojo) {
//        System.out.println("inside customer service impl");
//        Customer customer = new Customer();
//        customer.setFullName(customerPojo.getFullName());
//        customer.setPhone(customerPojo.getPhone());
//        customer.setRoomType(customerPojo.getRoomType() );
//        customer.setNumberOfPeople(customerPojo.getNumberOfPeople());
//        customer.setCheckInDate(customerPojo.getCheckInDate());
//        customer.setCheckOutDate(customerPojo.getCheckOutDate());
//        return null;
//    }
//}

import com.system.web_backend_individual1.Entity.Customer;
import com.system.web_backend_individual1.Pojo.CustomerPojo;
import com.system.web_backend_individual1.Repo.CustomerRepo;
import com.system.web_backend_individual1.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
