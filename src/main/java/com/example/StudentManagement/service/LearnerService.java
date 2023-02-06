package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.LearnerDTO;
import com.example.StudentManagement.dto.Request.LearnerUpdateDTO;

import java.util.List;

public interface LearnerService {

     public String saveLearner(LearnerDTO learnerDTO);

     String deleteLearner(int learnerID);

     List<LearnerDTO> getAllLearners();

     LearnerDTO getLearnerById(int learnerID);

     String updateLearner(LearnerUpdateDTO learnerUpdateDTO);
}
