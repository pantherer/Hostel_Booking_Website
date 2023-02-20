package com.system.web_backend_individual1.Controller;

import com.system.web_backend_individual1.Entity.Customer;
import com.system.web_backend_individual1.Entity.Gallery;
import com.system.web_backend_individual1.Pojo.GalleryPojo;
import com.system.web_backend_individual1.Services.CustomerService;
import com.system.web_backend_individual1.Services.GalleryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
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
    @GetMapping("/deleteList/{id}")
    public String deleteList(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/add-room")
    public String getAddProductPage(Model model) {
        model.addAttribute("gallery", new GalleryPojo());
        return "galleryForm";
    }
    @GetMapping("/galleryList")
    public String getGalleryList(Model model){
        List<Gallery> galleries = galleryService.fetchAll();
        model.addAttribute("gallery", galleries.stream().map(gallery ->
                Gallery.builder()
                        .id(gallery.getId())
                        .name(gallery.getName())
                        .description(gallery.getDescription())
                        .seater(gallery.getSeater())
                        .imageBase64(getImageBase64(gallery.getPhoto()))
                        .price(gallery.getPrice())
                        .build()
                ));
        return "RoomList";
    }
    @GetMapping("/editGallery/{id}")
    public String editGallery(@PathVariable("id") Integer id, Model model) {
        Gallery gallery = galleryService.fetchById(id);
        model.addAttribute("gallery", new GalleryPojo(gallery));
        return "galleryForm";
    }
    @GetMapping("/deleteGallery/{id}")
    public String deleteGallery(@PathVariable("id") Integer id) {
        galleryService.deleteById(id);
        return "redirect:/admin/galleryList";
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

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Gallery/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }


}
