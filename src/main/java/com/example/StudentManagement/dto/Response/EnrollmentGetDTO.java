package com.example.StudentManagement.dto.Response;

import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Payment;
import com.example.StudentManagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentGetDTO {

    private Date date;
    private boolean active_state;
    private User user;
    private Course course;
    private Payment payment;
}
