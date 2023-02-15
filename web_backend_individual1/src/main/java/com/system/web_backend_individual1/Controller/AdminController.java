package com.system.web_backend_individual1.Controller;

import com.system.web_backend_individual1.Entity.Customer;
import com.system.web_backend_individual1.Pojo.GalleryPojo;
import com.system.web_backend_individual1.Services.CustomerService;
import com.system.web_backend_individual1.Services.GalleryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final GalleryService galleryService;
    private final CustomerService customerService;
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        List<Customer> customers = customerService.fetchAll();
        model.addAttribute("bookinglist", customers);
        return "Dashboard";
    }

    @GetMapping("/add-room")
    public String getAddProductPage(Model model) {
        model.addAttribute("gallery", new GalleryPojo());
        return "galleryForm";
    }

    @PostMapping("/save/room")
    public String saveProduct(@Valid GalleryPojo galleryPojo) throws IOException {
        galleryService.save(galleryPojo);
        return "redirect:/landing/gallery";
    }
    @GetMapping("/bookinglist")
    public String getBookingList(Model model) {
        List<Customer> customers = customerService.fetchAll();
        model.addAttribute("bookinglist", customers);
        return "bookingList";
    }
    @GetMapping("/adminProfile")
    public String getAdminProfile(){
        return "adminProfile";
    }


}
