package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.CourseDTO;
import com.example.StudentManagement.dto.Paginated.PaginatedResponseDTO;
import com.example.StudentManagement.dto.Request.CourseUpdateDTO;

public interface CourseService{
    String saveCourse(CourseDTO courseDTO);

    Object getAllCourse();

    PaginatedResponseDTO getAllActiveCourses(int page, int size);

    Object getUserById(int courseID);

    Object deleteUser(int courseID);

    Object updateUser(CourseUpdateDTO courseUpdateDTO);
}
