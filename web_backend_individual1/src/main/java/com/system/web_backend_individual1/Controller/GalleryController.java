//package com.system.web_backend_individual1.Controller;
//
//import ch.qos.logback.core.model.Model;
//import com.system.web_backend_individual1.Entity.Gallery;
//import com.system.web_backend_individual1.Services.GalleryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Base64;
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/Gallery")
//public class GalleryController {
//    private final GalleryService galleryService;
//    @GetMapping("/view")
//    public String getGallery(Model model){
//        List<Gallery> galleries = galleryService.fetchAll();
//        model.addAttribute("gallery", galleries.stream().map(gallery ->
//                        Gallery.builder()
//                                .id(gallery.getId())
//                                .imageBase64(getImageBase64(gallery.getPhoto()))
//                                .name(gallery.getName())
//                                .seater(gallery.getSeater())
//                                .price(gallery.getPrice())
//                                .description(gallery.getDescription())
//                                .build()
//                )
//        );
//        return "showGallery";
//    }
//    public String getImageBase64(String fileName) {
//        String filePath = System.getProperty("user.dir") + "/Gallery/";
//        File file = new File(filePath + fileName);
//        byte[] bytes = new byte[0];
//        try {
//            bytes = Files.readAllBytes(file.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        String base64 = Base64.getEncoder().encodeToString(bytes);
//        return base64;
//    }
//}
