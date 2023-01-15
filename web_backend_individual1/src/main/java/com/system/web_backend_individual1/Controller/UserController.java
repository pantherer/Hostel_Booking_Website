package com.system.web_backend_individual1.Controller;

import com.system.web_backend_individual1.Pojo.UserPojo;
import com.system.web_backend_individual1.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
//    private final ValidationAutoConfiguration validationAutoConfiguration;
    @GetMapping("/add")
    public String AddUser(Model model){
        model.addAttribute("user", new UserPojo());
        return "registration";
    }
    @PostMapping("/save")
    public String SaveUser(UserPojo userPojo){
        userService.save_user(userPojo);
        return "dashboard";
    }
}
