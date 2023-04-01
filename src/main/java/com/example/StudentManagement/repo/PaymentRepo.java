package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    boolean existsByEnrollment(Enrollment enrollment);
}
