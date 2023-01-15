package com.system.web_backend_individual1.Services.impl;
import com.system.web_backend_individual1.Entity.User;
import com.system.web_backend_individual1.Pojo.UserPojo;
import com.system.web_backend_individual1.Repo.UserRepo;
import com.system.web_backend_individual1.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    @Override
    public String save_user(UserPojo userPojo){
        User user = new User();
        user.setFullname(userPojo.getFullname());
        user.setPhone(userPojo.getPhone());
        user.setAddress(userPojo.getAddress());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }
}
