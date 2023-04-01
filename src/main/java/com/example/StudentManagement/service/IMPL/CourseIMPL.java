package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.dto.CourseDTO;
import com.example.StudentManagement.dto.Paginated.PaginatedResponseDTO;
import com.example.StudentManagement.dto.Request.CourseUpdateDTO;
import com.example.StudentManagement.dto.Response.CourseGetDTO;
import com.example.StudentManagement.dto.UserDTO;
import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.exception.NotFoundException;
import com.example.StudentManagement.repo.CourseRepo;
import com.example.StudentManagement.service.CourseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseIMPL implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String saveCourse(CourseDTO courseDTO) {

        Course course = new Course(
                courseDTO.getCourseName(),
                courseDTO.getCourseDescription(),
                courseDTO.isActiveState(),
                courseDTO.getStartDate(),
                courseDTO.getEndDate()

        );

        boolean CourseName = courseRepo.existsByCourseName(course.getCourseName());

        if (!CourseName) {

            courseRepo.save(course);

        } else {
            return "Course has already exist";
        }

        return "New course has been saved";
    }

    @Override
    public List<CourseGetDTO> getAllCourse() {

        List<Course> allCourses = courseRepo.findAll();

        List<CourseGetDTO> courseGetDTOS = new ArrayList<>();

        for (Course course : allCourses) {
            CourseGetDTO courseGetDTO = new CourseGetDTO(
                    course.getCourseName(),
                    course.getCourseDescription(),
                    course.isActiveState(),
                    course.getStartDate(),
                    course.getEndDate()
            );

            courseGetDTOS.add(courseGetDTO);
        }
        return courseGetDTOS;
    }

    @Override
    public PaginatedResponseDTO getAllActiveCourses(int page, int size) {

        boolean activeClass = true;

        Page<User> coursePage = courseRepo.findAllByActiveState(activeClass, PageRequest.of(page, size));
        if (coursePage.getSize() < 1) {
            throw new NotFoundException("No Class Found");
        }
        return new PaginatedResponseDTO(modelMapper.map(coursePage, new TypeToken<List<UserDTO>>() {
        }.getType()),
                courseRepo.countAllByActiveStateEquals(activeClass));
    }

    @Override
    public CourseGetDTO getUserById(int courseID) {

        if (courseRepo.existsById(courseID)) {
            Course course = courseRepo.getById(courseID);

            CourseGetDTO courseGetDTO = new CourseGetDTO(
                    course.getCourseName(),
                    course.getCourseDescription(),
                    course.isActiveState(),
                    course.getStartDate(),
                    course.getEndDate()
            );
            return courseGetDTO;
        } else {

            throw new NotFoundException("Class Id is not found");
        }
    }

    @Override
    public String deleteUser(int courseID) {

        if (courseRepo.existsById(courseID)) {

            courseRepo.deleteById(courseID);

            return "Course has been deleted";
        } else
            throw new NotFoundException("Course is not found. cant be deleted");
    }

    @Override
    public String updateUser(CourseUpdateDTO courseUpdateDTO) {

        if (courseRepo.existsById(courseUpdateDTO.getCourseID())) {
            Course course = courseRepo.getById(courseUpdateDTO.getCourseID());

            course.setCourseName(courseUpdateDTO.getCourseName());
            course.setCourseDescription(courseUpdateDTO.getCourseDescription());
            course.setStartDate(courseUpdateDTO.getStartDate());
            course.setEndDate(courseUpdateDTO.getEndDate());

            courseRepo.save(course);
            return ("User has been updated");
        } else {

            throw new NotFoundException("Course is not found");
        }
    }
}
