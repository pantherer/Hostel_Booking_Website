package com.system.web_backend_individual1.Repo;
import com.system.web_backend_individual1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select * from USERS where username=?1", nativeQuery = true)
    Optional<User> findByUsername(String username);
    User findByUsernameAndOTP(String username, String OTP);
}
