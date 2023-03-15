package com.example.StudentManagement.service.IMPL;

import org.springframework.stereotype.Service;

@Service
public class LearnerIMPL {

//    @Autowired
//    LearnerRepo learnerRepo;
//
//    @Override
//    public String saveLearner(LearnerDTO learnerDTO) {
//
//        Learner learner = new Learner(
//                learnerDTO.getLearnerID(),
//                learnerDTO.getPhoneNumber(),
//                learnerDTO.
//        );
//        System.out.println(learner.getLearnerID()+"leranerID");
//        if (learnerRepo.existsByEmail(learnerDTO.getEmail())) {
//            throw new DuplicateKeyException("Customer is already exist");
//
//        } else {
//            learnerRepo.save(learner);
//            return learner.getFirstName() + learner.getLastName() + "saved";
//        }
//    }
//
//    @Override
//    public String deleteLearner(int learnerID) {
//
//        if (learnerRepo.existsById(learnerID)) {
//            learnerRepo.deleteById(learnerID);
//            return "Learner is deleted";
//
//        } else {
//            throw new DuplicateKeyException("Learner doesn't exist");
//        }
//    }
//
//    @Override
//    public List<LearnerDTO> getAllLearners() {
//
//        List<Learner> learnersList = learnerRepo.findAll();
//
//        List<LearnerDTO> learnerDTOList = new ArrayList<>();
//        for (Learner learner : learnersList) {
//            LearnerDTO learnerDTO = new LearnerDTO(
//                    learner.getLearnerID(),
//                    learner.getFirstName(),
//                    learner.getLastName(),
//                    learner.getEmail(),
//                    learner.getPhoneNumber(),
//                    learner.isActiveState()
//            );
//
//            learnerDTOList.add(learnerDTO);
//        }
//        return learnerDTOList;
//    }
//
//    @Override
//    public LearnerDTO getLearnerById(int learnerID) {
//
//        Learner learner = learnerRepo.getById(learnerID);
//
//        LearnerDTO learnerDTO = new LearnerDTO(
//                learner.getLearnerID(),
//                learner.getFirstName(),
//                learner.getLastName(),
//                learner.getEmail(),
//                learner.getPhoneNumber(),
//                learner.isActiveState()
//        );
//        return learnerDTO;
//    }
//
//    @Override
//    public String updateLearner(LearnerUpdateDTO learnerUpdateDTO) {
//
//        if(learnerRepo.existsById(learnerUpdateDTO.getLearnerID())) {
//            Learner learner = learnerRepo.getById(learnerUpdateDTO.getLearnerID());
//            learner.setFirstName(learnerUpdateDTO.getFirstName());
//            learner.setLastName(learnerUpdateDTO.getLastName());
//            learner.setEmail(learnerUpdateDTO.getEmail());
//            learner.setPhoneNumber(learnerUpdateDTO.getPhoneNumber());
//
//            learnerRepo.save(learner);
//            return learnerUpdateDTO.getFirstName() + learnerUpdateDTO.getLastName() + "saved";
//
//        }else {
//            throw new DuplicateKeyException("Learner doesn't exist");
//        }
//    }
}
