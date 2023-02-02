package com.system.web_backend_individual1.Pojo;

import com.system.web_backend_individual1.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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