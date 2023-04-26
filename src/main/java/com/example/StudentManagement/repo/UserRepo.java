package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    boolean existsByUserName(String userName);

    Page<User> findAllByActiveState(boolean activeUser, Pageable pageable);

    long countAllByActiveStateEquals(boolean activeUser);


    @Query(value ="select u.user_name from user u, address a where u.active_state = ?1 and a.city = ?2 and u.user_id=a.user_id" ,nativeQuery = true)
    String findAllByActiveStateAndCity(boolean activeUser, String city);

    int countAllByActiveStateAndAgeGreaterThanEqual(boolean activeUser, int age);

//    int countAllByActiveState(boolean activeUser);
}
