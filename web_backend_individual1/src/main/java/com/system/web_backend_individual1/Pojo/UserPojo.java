package com.system.web_backend_individual1.Pojo;

import com.system.web_backend_individual1.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;
    private String fullname;
    private String phone;
    private String address;
    private String username;
    private String password;
    public UserPojo(User user){
        this.id = user.getId();
        this.fullname=user.getFullname();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.username=user.getUsername();
        this.password=user.getPassword();
    }
}
