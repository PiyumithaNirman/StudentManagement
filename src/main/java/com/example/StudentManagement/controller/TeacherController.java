package com.example.StudentManagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@CrossOrigin
public class TeacherController {

//    @Autowired
//    TeacherService teacherService;
//
//    @PostMapping("/save")
//    public ResponseEntity<StandardResponse> saveLearner(@RequestBody TeacherDTO teacherDTO){
//
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",teacherService.saveTeacher(teacherDTO)),
//                HttpStatus.OK
//        );
//    }
//
//    @DeleteMapping(path ="/delete/{id}")
//    public ResponseEntity<StandardResponse> deleteLearner(@PathVariable ( value = "id" ) int learnerID){
//
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",teacherService.deleteTeacher(learnerID)),
//                HttpStatus.OK
//        );
//    }
//
//    @GetMapping("/getAllLearners")
//    public ResponseEntity<StandardResponse> getAllLearners(){
//        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
//
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",allTeachers),
//                HttpStatus.OK
//        );
//    }
//
//    @GetMapping(
//            path = "getLearner",
//            params = "id"
//    )
//    public ResponseEntity<StandardResponse> getTeacherById(@RequestParam(value = "id") int teacherID){
//        TeacherDTO teacherDTO = teacherService.getTeacherById(teacherID);
//
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",teacherDTO),
//                HttpStatus.OK
//        );
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<StandardResponse> updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO){
//
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",teacherService.updateTeacher(teacherUpdateDTO)),
//                HttpStatus.OK
//        );
//    }
}