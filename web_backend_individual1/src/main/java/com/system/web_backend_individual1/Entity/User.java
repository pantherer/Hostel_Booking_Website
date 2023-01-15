package com.system.web_backend_individual1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "hms_user_seq_gen", sequenceName = "hms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FullName")
    private String fullname;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;


}
