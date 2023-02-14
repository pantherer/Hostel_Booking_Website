package com.system.web_backend_individual1.Pojo;



import com.system.web_backend_individual1.Entity.Gallery;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleryPojo {
    private Integer id;
    private MultipartFile photo;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @NotEmpty(message = "Seater can't be empty")
    private String seater;
    @NotEmpty(message = "Price can't be empty")
    private String price;
    @NotEmpty(message = "Description can't be Empty")
    private String description;

    public GalleryPojo(Gallery gallery) {
        this.id = gallery.getId();
        this.name = gallery.getName();
        this.seater = gallery.getSeater();
        this.price = gallery.getPrice();
        this.description = gallery.getDescription();
    }
}

