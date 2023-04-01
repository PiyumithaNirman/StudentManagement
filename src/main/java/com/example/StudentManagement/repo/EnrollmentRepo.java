package com.example.StudentManagement.repo;

import com.example.StudentManagement.dto.EnrollmentDTO;
import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {

    boolean existsByUser(User user);
}
