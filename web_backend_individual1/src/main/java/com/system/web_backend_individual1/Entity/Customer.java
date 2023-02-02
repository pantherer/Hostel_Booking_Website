package com.system.web_backend_individual1.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @SequenceGenerator(name = "hms_user_seq_gen", sequenceName = "hms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FullName")
    private String fullname;

    @Column(name = "PhoneNumber")
    private String phone;

    @Column(name = "RoomType")
    private String room_type;

    @Column(name = "CheckInDate")
    private String check_in;

    @Column(name = "CheckOutDate")
    private String check_out;

}