package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.dto.UserDTO;
import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.repo.RoleRepo;
import com.example.StudentManagement.repo.UserRepo;
import com.example.StudentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserIMPL implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String getPasswordEncoder(String Password){

        return passwordEncoder.encode(Password);
    }

    @Override
    public String saveLearner(UserDTO userDTO) {

        Role role = roleRepo.getAllByRoleName(String.valueOf(userDTO.getRoleTypes()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                getPasswordEncoder(userDTO.getPassword()),
                userDTO.getUserName(),
                userDTO.getPhoneNumber(),
                userDTO.isActiveState()
        );

        user.setRole(roles);

        boolean UserName = userRepo.existsByUserName(user.getUserName());

        if (!UserName) {

            userRepo.save(user);
        } else {
            return "User has already exist";
        }

        return "New user has been saved";
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> allUsers = userRepo.findAll();

        List<UserDTO> allUsersDTO = new ArrayList<>();

        for (User user: allUsers) {
            UserDTO userDTO = new UserDTO(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUserName(),
                    user.getPhoneNumber(),
                    user.isActiveState(),
                    user.getAddresses(),
                    user.getCourses(),
                    user.getEnrollments(),
                    user.getRole()
            );

            allUsersDTO.add(userDTO);
        }
        return allUsersDTO;
    }

    @Override
    public UserDTO getUserById(int learnerID) {

        User user = userRepo.getById(learnerID);

        UserDTO userDTO = new UserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPhoneNumber(),
                user.isActiveState(),
                user.getAddresses(),
                user.getCourses(),
                user.getEnrollments(),
                user.getRole()
        );
        return userDTO;
    }

}
