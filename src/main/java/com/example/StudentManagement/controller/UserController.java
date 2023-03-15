package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.UserDTO;
import com.example.StudentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public String saveLearner(@RequestBody UserDTO userDTO){

        return userService.saveLearner(userDTO);
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(
            path = "/getUser",
            params = "id"
    )
    public UserDTO getUser(@RequestParam(value = "id")int learnerID){
        return userService.getUserById(learnerID);
    }


}
