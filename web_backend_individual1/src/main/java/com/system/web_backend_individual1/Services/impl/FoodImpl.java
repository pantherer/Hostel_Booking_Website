package com.system.web_backend_individual1.Services.impl;
import com.system.web_backend_individual1.Entity.Food;
import com.system.web_backend_individual1.Pojo.FoodPojo;
import com.system.web_backend_individual1.Repo.FoodRepo;
import com.system.web_backend_individual1.Services.FoodServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodImpl implements FoodServices {
    public final FoodRepo foodRepo;


    @Override
    public String save(FoodPojo foodPojo){
        Food food = new Food();
        food.setItem(foodPojo.getItem());
        food.setRoom_no(foodPojo.getRoom_no());
        food.setMobile_no(foodPojo.getMobile_no());
        food.setQuantity(foodPojo.getQuantity());
        foodRepo.save(food);
        return null;
    }
}

