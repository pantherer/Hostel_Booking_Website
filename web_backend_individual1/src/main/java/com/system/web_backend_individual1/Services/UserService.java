package com.system.web_backend_individual1.Services;

import com.system.web_backend_individual1.Pojo.UserPojo;

public interface UserService {
    String save_user(UserPojo userPojo);


    UserPojo findByUsername(String username);

    void sendEmail();
    String update(UserPojo userPojo);
}
