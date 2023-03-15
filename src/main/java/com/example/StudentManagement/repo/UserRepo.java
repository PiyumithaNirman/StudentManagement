package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
//    boolean existsByEmail(String email);

//    User findByUserName(String userName);

    User findByUserName(String userName);

    boolean existsByUserName(String userName);

//    User findByEmail(String userEmail);
}
