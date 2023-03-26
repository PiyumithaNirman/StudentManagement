package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.RoleDTO;
import com.example.StudentManagement.service.RoleService;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> createNewRole(@RequestBody RoleDTO roleDTO){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",roleService.createNewRole(roleDTO)),
                HttpStatus.OK
        );
    }
}
