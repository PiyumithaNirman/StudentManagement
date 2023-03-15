package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.RoleDTO;
import com.example.StudentManagement.entity.Role;

public interface RoleService {

    String createNewRole(RoleDTO roleDTO);
}
