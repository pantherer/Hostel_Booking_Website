package com.system.web_backend_individual1.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gallery")
public class Gallery {
    @Id
    @SequenceGenerator(name = "gallery_seq_gen", sequenceName = "gallery_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gallery_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String photo;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "seater", nullable = false)
    private String seater;
    @Column(name = "price", nullable = false)
    private String price;
    @Column(name = "description", nullable = false)
    private String description;
    @Transient
    private String imageBase64;


}
