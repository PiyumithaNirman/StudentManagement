package com.example.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {

    private int addressID;
    private String street;
    private String city;
    private String state;
    private int zipCode;
}