package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.Paginated.PaginatedResponseDTO;
import com.example.StudentManagement.dto.Request.UserUpdateDTO;
import com.example.StudentManagement.dto.UserDTO;
import com.example.StudentManagement.service.UserService;
import com.example.StudentManagement.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/registerUser")
    public ResponseEntity<StandardResponse> saveLearner(@RequestBody @Valid UserDTO userDTO){

        String saveLearner = userService.saveLearner(userDTO);
        LOGGER.info(saveLearner+" LOGGER");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",saveLearner),
                HttpStatus.OK
        );
    }

    @GetMapping("/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> getAllUsers(){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",userService.getAllUsers()),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/getAllActiveUsers"},
            params = {"page","size"}
    )
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> getAllActiveUsers(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")int size)
    {
        PaginatedResponseDTO paginatedResponseDTO = userService.getAllActiveUsers(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/getUser",
            params = "id"
    )
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<StandardResponse> getUser(@RequestParam(value = "id")int userID){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",userService.getUserById(userID)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable(value = "id")int userID){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",userService.deleteUser(userID)),
                HttpStatus.OK
        );
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<StandardResponse> updateUser(@RequestBody UserUpdateDTO userUpdateDTO){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",userService.updateUser(userUpdateDTO)),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/getQuarry",
            params = "city"
    )
    public ResponseEntity<StandardResponse> getUserQuary(@RequestParam("city")String city){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",userService.getUserQuarry(city)),
                HttpStatus.OK
        );
    }
}
