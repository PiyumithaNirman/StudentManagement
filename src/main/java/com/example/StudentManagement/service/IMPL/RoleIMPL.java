package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.dto.RoleDTO;
import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.repo.RoleRepo;
import com.example.StudentManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleIMPL implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public String createNewRole(RoleDTO roleDTO) {

        Role role = new Role(
                roleDTO.getRoleName(),
                roleDTO.getDescription()
        );

        if (!roleRepo.existsById(roleDTO.getRoleName())) {

            roleRepo.save(role);
            return "Successfully create new role";

        }else {
            return "Role has already been added";
        }
    }
}

