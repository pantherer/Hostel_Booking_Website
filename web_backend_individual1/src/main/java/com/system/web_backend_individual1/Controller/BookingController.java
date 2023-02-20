
//import com.system.springboot4.pojo.CustomerPojo;
//import com.system.springboot4.services.CustomerService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/customer")
//public class BookingController {
//    private final CustomerService customerService;
//    private final ValidationAutoConfiguration validationAutoConfiguration;
//
//    @GetMapping("/customer")
//    public String BookHotel(Model model) {
//        model.addAttribute("customer", new CustomerPojo());
//        return "customer";
//    }
//
//
//    @PostMapping("/savebook")
//    public String saveBooking(@Valid CustomerPojo customerPojo) {
//        customerService.save(customerPojo);
//        return "redirect:homepage";
//    }
//}
package com.system.web_backend_individual1.Controller;

import com.system.web_backend_individual1.Pojo.CustomerPojo;
import com.system.web_backend_individual1.Services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final CustomerService customerService;
//    private final ValidationAutoConfiguration validationAutoConfiguration;
//    @GetMapping("/view")
//    public  String ViewCust(Model model){
//        System.out.println("inside ViewCust");
//        return "booking";
//    }

    @GetMapping("/add")
    public String AddCustomer(Model model){
//        System.out.println("inside AddCustomer");
        model.addAttribute("booking", new CustomerPojo());
        return "book";
    }
    @PostMapping("/save")
    public String SaveCustomer(@Valid CustomerPojo customerPojo){
//        System.out.println("inside save customer");
        customerService.save_customer(customerPojo);
        return "redirect:/landing/view";
    }
}


