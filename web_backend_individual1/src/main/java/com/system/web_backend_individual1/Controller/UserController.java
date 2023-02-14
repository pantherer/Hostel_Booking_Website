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
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/request-password-reset")
    public String requestPasswordReset() {
        return "forgotPassword";
    }

    @PostMapping("/request-password-reset")
    public String processPasswordResetRequest(@RequestParam("username") String username, Model model) {
        userService.processPasswordResetRequest(username);
        model.addAttribute("message", "A password reset OTP has been sent to your email. Please check your inbox!!!");
        return "forgotPasswordOTP";
    }

    @GetMapping("/reset-password")
    public String resetPassword(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "forgotPasswordOTP";
    }

    @PostMapping("/reset-password")
    public String processPasswordReset(@RequestParam("username") String username,
                                       @RequestParam(required=false, name = "OTP") String OTP,
                                       @RequestParam("password") String password,
                                       Model model) {
        userService.resetPassword(username, OTP, password);
        model.addAttribute("message", "Your password has been reset successfully.");
        return "forgotPasswordOTP";
    }

}


