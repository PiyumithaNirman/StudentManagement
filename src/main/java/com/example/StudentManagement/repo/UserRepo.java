package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    boolean existsByUserName(String userName);

    Page<User> findAllByActiveState(boolean activeUser, Pageable pageable);


    long countAllByActiveStateEquals(boolean activeUser);

}
