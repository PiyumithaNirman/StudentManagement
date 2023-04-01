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
    private String phoneNumber;

    private int age;
    private boolean activeState;

    private String roleName;

    private String description;

//    private RoleTypes roleTypes;

//    private Set<Address> addresses;
//    private Set<Course> courses;
//    Set<Enrollment> enrollments;
//    Set<Role> roles;

}
