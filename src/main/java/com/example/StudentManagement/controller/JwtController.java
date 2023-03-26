package com.example.StudentManagement.controller;

import com.example.StudentManagement.entity.JwtRequest;
import com.example.StudentManagement.entity.JwtResponse;
import com.example.StudentManagement.service.JwtService;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/security")
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public ResponseEntity<StandardResponse> createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",jwtService.createJwtToken(jwtRequest)),
                HttpStatus.OK
        );
    }
}
