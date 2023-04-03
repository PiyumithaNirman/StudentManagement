package com.example.StudentManagement.controller;

import com.example.StudentManagement.service.ImageService;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/image")
@CrossOrigin
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping(path = "/uploadImage")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<StandardResponse> uploadImage(@RequestParam("image") MultipartFile file,@RequestParam("id") int id) throws IOException {
        String uploadImage = imageService.uploadImage(file,id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",uploadImage),
                HttpStatus.OK
                );
    }

    @GetMapping(path = "/downloadImage/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<?> downloadImage(@PathVariable("id")int id){

        byte[] imageData = imageService.downloadImage(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
