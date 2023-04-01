package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CourseRepo extends JpaRepository<Course,Integer> {
    boolean existsByCourseName(String courseName);

    Page<User> findAllByActiveState(boolean activeClass, PageRequest of);

    long countAllByActiveStateEquals(boolean activeClass);

    Course findByCourseName(String courseName);
}
