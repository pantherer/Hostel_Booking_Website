package com.system.web_backend_individual1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping("/view")
    public String GetDashboard(){
        return "dashboard";
    }
    @GetMapping("/landing")
    public String GetLanding(){
        return "landingPage";
    }

}
