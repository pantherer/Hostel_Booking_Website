package com.system.web_backend_individual1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//package com.system.web_backend_individual1.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "customer")
//public class Customer {
//    @Id
//    @SequenceGenerator(name = "cms_user_seq_gen", sequenceName = "cms_user_id_seq", allocationSize = 1)
//    @GeneratedValue(generator = "cms_user_seq_gen", strategy = GenerationType.SEQUENCE)
//    private Integer id;
//
//    @Column(name="full_name", nullable = false)
//    private String fullName;
//
//    @Column(name = "phone_no",nullable = false)
//    private String phone;
//
//    @Column(name = "room_Type")
//    private String roomType;
//
//    @Column(name = "no_people")
//    private String numberOfPeople;
//
//    @Column(name = "check_in")
//    private String checkInDate;
//
//    @Column(name = "check_out")
//    private String checkOutDate;
//
//
//
//}
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