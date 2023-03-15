package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveLearner(UserDTO userDTO);
    List<UserDTO>getAllUsers();

    UserDTO getUserById(int learnerID);

//    void saveAdmin();

}
