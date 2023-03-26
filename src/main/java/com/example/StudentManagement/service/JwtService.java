package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.JwtRequest;
import com.example.StudentManagement.entity.JwtResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception;

    UserDetails loadUserByUsername(String username);

}


