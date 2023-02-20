package com.system.web_backend_individual1.Services.impl;

import com.system.web_backend_individual1.Entity.Gallery;
import com.system.web_backend_individual1.Pojo.GalleryPojo;
import com.system.web_backend_individual1.Repo.GalleryRepo;
import com.system.web_backend_individual1.Services.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {
    private final GalleryRepo galleryRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/Gallery";

    @Override
    public List<Gallery> fetchAll() {
        return this.galleryRepo.findAll();
    }

    @Override
    public String save(GalleryPojo galleryPojo) throws IOException {
        Gallery gallery=new Gallery();
        if(gallery.getId()!=null){
            gallery.setId(galleryPojo.getId());
        }
        gallery.setName(galleryPojo.getName());
        gallery.setSeater(galleryPojo.getSeater());
        gallery.setPrice(galleryPojo.getPrice());
        gallery.setDescription(galleryPojo.getDescription());
        if(galleryPojo.getPhoto()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, galleryPojo.getPhoto().getOriginalFilename());
            fileNames.append(galleryPojo.getPhoto().getOriginalFilename());
            Files.write(fileNameAndPath, galleryPojo.getPhoto().getBytes());

            gallery.setPhoto(galleryPojo.getPhoto().getOriginalFilename());
        }

        galleryRepo.save(gallery);
        return "created";
    }

    @Override
    public void deleteById(Integer id) {
        this.galleryRepo.deleteById(id);
    }

    @Override
    public Gallery fetchById(Integer id) {
        return galleryRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}

