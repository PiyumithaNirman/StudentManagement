package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.AddressDTO;
import com.example.StudentManagement.repo.AddressRepo;
import com.example.StudentManagement.service.AddressService;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@CrossOrigin
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/saveAddress")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<StandardResponse> saveAddress(@RequestBody AddressDTO addressDTO){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",addressService.saveAddress(addressDTO)),
                HttpStatus.OK
        );
    }
}
