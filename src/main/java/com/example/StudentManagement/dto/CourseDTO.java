package com.example.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {

    private String courseName;
    private String courseDescription;
    private boolean activeState;
    private Date startDate;
    private Date endDate;
}
