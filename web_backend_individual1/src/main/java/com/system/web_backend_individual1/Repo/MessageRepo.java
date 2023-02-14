package com.system.web_backend_individual1.Repo;

import com.system.web_backend_individual1.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Integer> {

}
