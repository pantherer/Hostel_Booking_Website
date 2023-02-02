package com.system.web_backend_individual1.Controller;
import com.system.web_backend_individual1.Pojo.UserPojo;
import com.system.web_backend_individual1.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;

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
    @PostMapping("/save")
    public String SaveUser(UserPojo userPojo){
        userService.save_user(userPojo);
        return "/login";
    }
    @GetMapping("/dashboard")
    public String GetDashboard(){
        return "/dashboard";
    }

    @GetMapping("/sendEmail")
    public String sendRegistrationEmail() {
        this.userService.sendEmail();
        return "emailsuccess";
    }
    @GetMapping("/profile")
    public String getUserProfile (Integer id, Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "/login";
        }
        model.addAttribute("update", new UserPojo());
        model.addAttribute("info", userService.findByUsername(principal.getName()));
        return "accountpage";
    }
    @PostMapping("/updateUser")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.save_user(userpojo);
        return "redirect:/user/profile";
    }
    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Gallery/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}


