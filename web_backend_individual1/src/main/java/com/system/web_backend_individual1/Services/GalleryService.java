package com.system.web_backend_individual1.Services;

import com.system.web_backend_individual1.Entity.Gallery;
import com.system.web_backend_individual1.Pojo.GalleryPojo;

import java.io.IOException;
import java.util.List;

public interface GalleryService {
    List<Gallery> fetchAll();

    String save(GalleryPojo galleryPojo) throws IOException;
}
