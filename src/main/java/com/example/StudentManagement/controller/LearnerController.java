package com.example.StudentManagement.controller;

import org.springframework.web.bind.annotation.*;

//
@RestController
@RequestMapping("api/v1/learner")
@CrossOrigin
public class LearnerController {
//
//    @Autowired
//    private LearnerService learnerService;
//
//    @PostMapping("/save")
//    public String saveLearner(@RequestBody LearnerDTO learnerDTO){
//
//        return learnerService.saveLearner(learnerDTO);
//    }
//
//    @DeleteMapping(path ="/delete/{id}")
//    public String deleteLearner(@PathVariable ( value = "id" ) int learnerID){
//        return learnerService.deleteLearner(learnerID);
//    }
//
//    @GetMapping("/getAllLearners")
//    public List<LearnerDTO> getAllLearners(){
//        List<LearnerDTO> allLearners = learnerService.getAllLearners();
//        return allLearners;
//    }
//
//    @GetMapping(
//            path = "getLearner",
//            params = "id"
//    )
//    public LearnerDTO getLearnerById(@RequestParam(value = "id") int learnerID){
//        LearnerDTO learner = learnerService.getLearnerById(learnerID);
//        return learner;
//    }
//
//    @PutMapping("/update")
//    public String updateLearner(@RequestBody LearnerUpdateDTO learnerUpdateDTO){
//        return learnerService.updateLearner(learnerUpdateDTO);
//    }
//
}
