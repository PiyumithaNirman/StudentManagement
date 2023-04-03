package com.example.StudentManagement.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImage(MultipartFile file, int id) throws IOException;

    byte[] downloadImage(int id);
}