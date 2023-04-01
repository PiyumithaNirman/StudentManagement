package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {

    private int userId;
    private String street;
    private String city;
    private String state;
    private int zipCode;
}
