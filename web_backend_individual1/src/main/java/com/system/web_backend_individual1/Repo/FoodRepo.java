package com.system.web_backend_individual1.Repo;
import com.system.web_backend_individual1.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {
}

