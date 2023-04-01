package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.EnrollmentDTO;
import com.example.StudentManagement.repo.EnrollmentRepo;
import com.example.StudentManagement.service.EnrollmentService;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/enrollment")
@CrossOrigin
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping("/enrollment")
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<StandardResponse> saveEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",enrollmentService.saveEnrollment(enrollmentDTO)),
                HttpStatus.OK
        );
    }
}
