package com.system.web_backend_individual1.Services;

import com.system.web_backend_individual1.Pojo.FoodPojo;
import jakarta.validation.Valid;

public interface FoodServices {
    String save (@Valid FoodPojo foodPojo);
}

