package com.system.web_backend_individual1.Controller;

import com.system.web_backend_individual1.Pojo.UserPojo;
import com.system.web_backend_individual1.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ValidationAutoConfiguration validationAutoConfiguration;
    @GetMapping("/add")
    public String AddUser(Model model){
        model.addAttribute("user", new UserPojo());
        return "registration";
    }
    public String SaveUser(@valid UserPojo userPojo){
        UserService.save_User(userPojo);
        return "dashboard";
    }
}
