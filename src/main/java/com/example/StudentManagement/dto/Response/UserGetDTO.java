package com.example.StudentManagement.dto.Response;

import com.example.StudentManagement.entity.Address;
import com.example.StudentManagement.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGetDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private int age;
    private boolean activeState;
//    private Set<Address> addresses;
//    private Set<Course> courses;
//    Set<Enrollment> enrollments;
    Set<Role> roles;


}
