package com.example.StudentManagement.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private String phoneNumber;
    private int age;
}
