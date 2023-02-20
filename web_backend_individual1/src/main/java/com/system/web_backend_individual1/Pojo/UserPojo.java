package com.system.web_backend_individual1.Pojo;

import com.system.web_backend_individual1.Entity.User;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Fullname can't be empty")
    private String fullname;
    @NotEmpty(message = "Number can't be empty")
    private String phone;
    @NotEmpty(message = "Address can't be empty")
    private String address;
    @NotEmpty(message = "Username can't be empty")
    private String username;
    @NotEmpty(message = "Password can't be empty")
    private String password;
    private String OTP;
    public UserPojo(User user){
        this.id = user.getId();
        this.fullname=user.getFullname();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.OTP = user.getOTP();
    }
}
