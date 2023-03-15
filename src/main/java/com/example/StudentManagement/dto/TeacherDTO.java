package com.example.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO {

    private int teacherID;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList phoneNumber;
    private boolean activeState;

//    public TeacherDTO(String firstName, String lastName, String email, ArrayList phoneNumber, boolean activeState) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.activeState = activeState;
//    }
}
