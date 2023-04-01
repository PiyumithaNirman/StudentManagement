package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.CourseDTO;
import com.example.StudentManagement.dto.Paginated.PaginatedResponseDTO;
import com.example.StudentManagement.dto.Request.CourseUpdateDTO;
import com.example.StudentManagement.service.CourseService;
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
@RequestMapping("api/v1/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/saveCourse")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    public ResponseEntity<StandardResponse> saveCourse(@RequestBody @Valid CourseDTO courseDTO){

        String saveCourse = courseService.saveCourse(courseDTO);
        LOGGER.info(saveCourse+" LOGGER");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",saveCourse),
                HttpStatus.OK
        );
    }

    @GetMapping("/getAllCourses")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> getAllCourses(){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",courseService.getAllCourse()),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/getAllActiveCourses"},
            params = {"page","size"}
    )
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> getAllActiveCourses(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")int size)
    {
        PaginatedResponseDTO paginatedResponseDTO = courseService.getAllActiveCourses(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/getCourse",
            params = "id"
    )
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','LEARNER')")
    public ResponseEntity<StandardResponse> getCourse(@RequestParam(value = "id")int courseID){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",courseService.getUserById(courseID)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/deleteCourse/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> deleteCourse(@PathVariable(value = "id")int courseID){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",courseService.deleteUser(courseID)),
                HttpStatus.OK
        );
    }

    @PutMapping("/updateCourse")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StandardResponse> updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",courseService.updateUser(courseUpdateDTO)),
                HttpStatus.OK
        );
    }
}
