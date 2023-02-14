package com.system.web_backend_individual1.Controller;

import com.system.web_backend_individual1.Entity.Gallery;

import com.system.web_backend_individual1.Pojo.CustomerPojo;

import com.system.web_backend_individual1.Pojo.MessagePojo;
import com.system.web_backend_individual1.Services.GalleryService;
import com.system.web_backend_individual1.Services.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/landing")
public class landingPageController {
    private final MessageService messageService;
    private final GalleryService galleryService;
    @GetMapping("/view")
    public String GetLandingPage(Model model) {
        model.addAttribute("message", new MessagePojo());
        return "landingPage";
    }
    @PostMapping("/saveMessage")
    public String SaveCustomer(@Valid MessagePojo messagePojo){
//        System.out.println("inside save customer");
        messageService.save_message(messagePojo);
        return "redirect:/landing/view";
    }
    @GetMapping("/gallery")
    public String GetGallery(Model model){
        List<Gallery> galleries = galleryService.fetchAll();
        model.addAttribute("gallery", galleries.stream().map(gallery ->
                        Gallery.builder()
                                .id(gallery.getId())
                                .imageBase64(getImageBase64(gallery.getPhoto()))
                                .name(gallery.getName())
                                .seater(gallery.getSeater())
                                .price(gallery.getPrice())
                                .description(gallery.getDescription())
                                .build()
                )
        );
        return "gallery";
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
//    @GetMapping("/viewImage")
//    public String addGallery( Model model) {
//        List<Gallery> gallerys = galleryServices.fetchAll();
//        model.addAttribute("imagelist", gallerys.stream().map(gallery ->
//                Gallery.builder()
//                        .id(gallery.getId())
//                        .name(gallery.getName())
//                        .imageBase64(getImageBase64(gallery.getImage()))
//                        .build()
//
//        ));
//        return "Admin/ViewImages";
//    }

}
