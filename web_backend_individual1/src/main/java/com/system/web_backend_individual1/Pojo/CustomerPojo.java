package com.system.web_backend_individual1.Pojo;

import com.system.web_backend_individual1.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//package com.system.web_backend_individual1.Pojo;
//
//import com.system.springboot4.entity.Customer;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//// Pojo backend ko validation ko laagi ekdamai important
//
//@Getter
//@Setter
//@NoArgsConstructor // dynamic banaunw duitai pass gareko
//@AllArgsConstructor // dynamic banaunw duitai pass gareko
//public class CustomerPojo {
//
//    private Integer id;
//    private String fullName;
//    private String phone;
//    private String roomType;
//    private String numberOfPeople;
//    private String checkInDate;
//    private String checkOutDate;
////
//    public CustomerPojo(Customer customer){
//        this.id= customer.getId();
//        this.fullName=customer.getFullName();
//        this.phone= customer.getPhone();
//        this.roomType= customer.getRoomType();
//        this.numberOfPeople= customer.getNumberOfPeople();
//        this.checkInDate= customer.getCheckInDate();
//        this.checkOutDate= customer.getCheckOutDate();
//
//    }
////    User Entity ma jun jun variable xw tai rakhney
//
//}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPojo {
    private Integer id;
    private String fullname;
    private String phone;
    private String room_type;
    private String check_in;
    private String check_out;

    public CustomerPojo(Customer customer){
        this.fullname = customer.getFullname();
        this.phone = customer.getPhone();
        this.room_type=customer.getRoom_type();
        this.check_in=customer.getCheck_in();
        this.check_out=customer.getCheck_out();
    }
}