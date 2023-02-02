package com.system.web_backend_individual1.Controller;
import com.system.web_backend_individual1.Pojo.FoodPojo;
import com.system.web_backend_individual1.Services.FoodServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orderFood")
public class FoodController {
    private final FoodServices foodServices;
    @GetMapping("/order")
    public String OrderFood(Model model){
        model.addAttribute("order", new FoodPojo());
        return "order_food_form";
    }
    @PostMapping("/saveorder")
    public String SaveOrder(@Valid FoodPojo foodPojo){
        foodServices.save(foodPojo);
        return "/order_food";
    }
}

