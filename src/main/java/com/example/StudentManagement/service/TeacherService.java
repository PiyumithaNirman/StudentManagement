package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.LearnerDTO;
import com.example.StudentManagement.dto.Request.TeacherUpdateDTO;
import com.example.StudentManagement.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    String saveTeacher(TeacherDTO teacherDTO);

    String deleteTeacher(int teacherID);


    List<TeacherDTO> getAllTeachers();

    TeacherDTO getTeacherById(int teacherID);

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);
}
