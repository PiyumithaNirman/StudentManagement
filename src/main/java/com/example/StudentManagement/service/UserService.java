package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.Paginated.PaginatedResponseDTO;
import com.example.StudentManagement.dto.Request.UserUpdateDTO;
import com.example.StudentManagement.dto.Response.UserGetDTO;
import com.example.StudentManagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveLearner(UserDTO userDTO);
    List<UserGetDTO>getAllUsers();

    UserGetDTO getUserById(int userID);

    String deleteUser(int userID);

    String updateUser(UserUpdateDTO userUpdateDTO);

    PaginatedResponseDTO getAllActiveUsers(int page, int size);

    String getUserQuarry(String city);
}
