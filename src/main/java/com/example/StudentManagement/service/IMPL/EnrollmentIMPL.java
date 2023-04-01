package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.dto.EnrollmentDTO;
import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.Payment;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.exception.NotFoundException;
import com.example.StudentManagement.repo.CourseRepo;
import com.example.StudentManagement.repo.EnrollmentRepo;
import com.example.StudentManagement.repo.PaymentRepo;
import com.example.StudentManagement.repo.UserRepo;
import com.example.StudentManagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class EnrollmentIMPL implements EnrollmentService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    PaymentRepo paymentRepo;            //optional //builder pattern

    @Autowired
    EnrollmentRepo enrollmentRepo;

    @Override
//    @Transactional
    public String saveEnrollment(EnrollmentDTO enrollmentDTO) {

        if (userRepo.existsById(enrollmentDTO.getUserId())) {
            User user = userRepo.getById(enrollmentDTO.getUserId());

            Course course = courseRepo.getById(enrollmentDTO.getCourseId());

            course.setUser(user);
            courseRepo.save(course);

            if (!enrollmentRepo.existsByUser(user)) {
                Enrollment enrollment = new Enrollment(
                        enrollmentDTO.getDate(),
                        enrollmentDTO.isActive_state(),
                        user,
                        course
                );

                enrollmentRepo.save(enrollment);

                if (!paymentRepo.existsByEnrollment(enrollment)) {
                    Payment payment = new Payment(
                            enrollmentDTO.getAmount(),
                            enrollmentDTO.getDate(),
                            enrollment
                    );

                    paymentRepo.save(payment);
                }

                else
                    throw new NotFoundException("User is not found");
            }
        }
        return "safas";
    }
}
