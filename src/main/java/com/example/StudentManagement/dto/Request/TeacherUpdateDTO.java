package com.example.StudentManagement.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherUpdateDTO {

    private int teacherID;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList phoneNumber;
    private boolean activeState;

//    public TeacherUpdateDTO(String firstName, String lastName, String email, ArrayList phoneNumber) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }
}
