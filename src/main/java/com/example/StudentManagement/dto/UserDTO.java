package com.example.StudentManagement.dto;

import com.example.StudentManagement.dto.enums.RoleTypes;
import com.example.StudentManagement.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private ArrayList phoneNumber;
    private boolean activeState;
    private RoleTypes roleTypes;

    private Set<Address> addresses;
    private Set<Course> courses;
    Set<Enrollment> enrollments;
    Set<Role> roles;

    public UserDTO(String firstName, String lastName, String userName, ArrayList phoneNumber, boolean activeState, Set<Address> addresses, Set<Course> courses, Set<Enrollment> enrollments, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
        this.addresses = addresses;
        this.courses = courses;
        this.enrollments = enrollments;
        this.roles = roles;
    }

}
