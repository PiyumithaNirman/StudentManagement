package com.example.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDTO {

    private Date Date;
    private boolean active_state;
    private Date endDate;
    private int userId;
    private int courseId;
    private int amount;
}
