package com.example.StudentManagement.dto.Request;

import com.example.StudentManagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseUpdateDTO {

    private int courseID;
    private String courseName;
    private String courseDescription;
    private boolean activeState;
    private Date startDate;
    private Date endDate;
    private User user;
}
