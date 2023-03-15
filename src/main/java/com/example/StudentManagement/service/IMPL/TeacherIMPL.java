package com.example.StudentManagement.service.IMPL;

import org.springframework.stereotype.Service;

@Service
public class TeacherIMPL {

//    @Autowired
//    TeacherRepo teacherRepo;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Override
//    public String saveTeacher(TeacherDTO teacherDTO) {
//
//        Teacher teacher = new Teacher(
//                teacherDTO.getFirstName(),
//                teacherDTO.getLastName(),
//                teacherDTO.getEmail(),
//                teacherDTO.getPhoneNumber(),
//                teacherDTO.isActiveState()
//        );
////        System.out.println(teacher.getTeacherID());
//        if (teacherRepo.existsByEmail(teacherDTO.getEmail())) {
//            throw new DuplicateKeyException("Customer is already exist");
//
//        } else {
//            teacherRepo.save(teacher);
//            return teacher.getFirstName() + teacher.getLastName() + "saved";
//        }
//    }

//    @Override
//    public String deleteTeacher(int learnerID) {
//
//        Teacher teacher = teacherRepo.getById(learnerID);
//        if (teacherRepo.existsById(learnerID)) {
//
//            teacherRepo.deleteById(learnerID);
//            return "Learner is deleted";
//
//        } else {
//            throw new NotFoundException("Learner doesn't exist");
//        }
//    }

//    @Override
//    public List<TeacherDTO> getAllTeachers() {
//
//        List<Teacher> teachersList = teacherRepo.findAll();

//        List<TeacherDTO> teachersDTOList = new ArrayList<>();
//        for (Teacher teacher : teachersList) {
//            TeacherDTO teacherDTO = new TeacherDTO(
//                    teacher.getTeacherID(),
//                    teacher.getFirstName(),
//                    teacher.getLastName(),
//                    teacher.getEmail(),
//                    teacher.getPhoneNumber(),
//                    teacher.isActiveState()
//            );
//
//            teachersDTOList.add(teacherDTO);
//        }

//        List<TeacherDTO> teachersDTOList = modelMapper.map(teachersList, new TypeToken<List<TeacherDTO>>() {}.getType());
//
//        return teachersDTOList;
//    }
//
//    @Override
//    public TeacherDTO getTeacherById(int teacherID) {
//
//        Teacher teacher = teacherRepo.getById(teacherID);
//
//        TeacherDTO teacherDTO = new TeacherDTO(
//                teacher.getTeacherID(),
//                teacher.getFirstName(),
//                teacher.getLastName(),
//                teacher.getEmail(),
//                teacher.getPhoneNumber(),
//                teacher.isActiveState()
//        );
//        return teacherDTO;
//    }
//
//    @Override
//    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
//
//        if(teacherRepo.existsById(teacherUpdateDTO.getTeacherID())) {
//            Teacher teacher = teacherRepo.getById(teacherUpdateDTO.getTeacherID());
//            teacher.setFirstName(teacherUpdateDTO.getFirstName());
//            teacher.setLastName(teacherUpdateDTO.getLastName());
//            teacher.setEmail(teacherUpdateDTO.getEmail());
//            teacher.setPhoneNumber(teacherUpdateDTO.getPhoneNumber());
//
//            teacherRepo.save(teacher);
//            return teacherUpdateDTO.getFirstName() + teacherUpdateDTO.getLastName() + "saved";
//
//        }else {
//            throw new NotFoundException("Teacher doesn't exist");
//        }
//    }
}
