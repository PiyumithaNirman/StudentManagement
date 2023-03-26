package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.dto.Paginated.PaginatedResponseDTO;
import com.example.StudentManagement.dto.Request.UserUpdateDTO;
import com.example.StudentManagement.dto.Response.UserGetDTO;
import com.example.StudentManagement.dto.UserDTO;
import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.exception.NotFoundException;
import com.example.StudentManagement.repo.RoleRepo;
import com.example.StudentManagement.repo.UserRepo;
import com.example.StudentManagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;

@Service
public class UserIMPL implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String getPasswordEncoder(String Password){

        return passwordEncoder.encode(Password);
    }

    @Override
    public String saveLearner(@Valid UserDTO userDTO) {

        Role role = roleRepo.getAllByRoleName(String.valueOf(userDTO.getRoleTypes()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                getPasswordEncoder(userDTO.getPassword()),
                userDTO.getUserName(),
                userDTO.getPhoneNumber(),
                userDTO.getAge(),
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
    public List<UserGetDTO> getAllUsers() {

        List<User> allUsers = userRepo.findAll();

        List<UserGetDTO> allUsersDTO = new ArrayList<>();

        for (User user: allUsers) {
            UserGetDTO userGetDTO = new UserGetDTO(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUserName(),
                    user.getPhoneNumber(),
                    user.getAge(),
                    user.isActiveState(),
                    user.getAddresses(),
                    user.getCourses(),
                    user.getEnrollments(),
                    user.getRole()
            );

            allUsersDTO.add(userGetDTO);
        }
        return allUsersDTO;
    }

    @Override
    public PaginatedResponseDTO getAllActiveUsers(int page, int size) {

        boolean activeUser = true;

        Page<User> usersPage = userRepo.findAllByActiveState(activeUser, PageRequest.of(page,size));
        if(usersPage.getSize()<1){
            throw new NotFoundException("No Data Found");
        }
        return new PaginatedResponseDTO(modelMapper.map(usersPage, new TypeToken<List<UserDTO>>() {}.getType()),
                userRepo.countAllByActiveStateEquals(activeUser));
    }

    @Override
    public UserGetDTO getUserById(int learnerID) {

        if(userRepo.existsById(learnerID)) {
            User user = userRepo.getById(learnerID);

            UserGetDTO userGetDTO = new UserGetDTO(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUserName(),
                    user.getPhoneNumber(),
                    user.getAge(),
                    user.isActiveState(),
                    user.getAddresses(),
                    user.getCourses(),
                    user.getEnrollments(),
                    user.getRole()
            );
            return userGetDTO;
        }else {
            System.out.println("User Id is not found");
            return null;
        }
    }

//    public void addTrigger() {
//        String query = "CREATE TRIGGER save_roles_on_user_delete ...";
//        jdbcTemplate.execute(query);
//    }

    @Override
    public String deleteUser(int userID) {

        if(userRepo.existsById(userID)){

            userRepo.deleteById(userID);
//            addTrigger();
            return "User has been deleted";
        }else
            return "User is not found. cant be deleted";
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {

        if(userRepo.existsById(userUpdateDTO.getUserId())){
            User user = userRepo.getById(userUpdateDTO.getUserId());

            user.setFirstName(userUpdateDTO.getFirstName());
            user.setLastName(userUpdateDTO.getLastName());
            user.setUserName(userUpdateDTO.getUserName());
            user.setPassword(passwordEncoder.encode(userUpdateDTO.getPassword()));
            user.setPhoneNumber(userUpdateDTO.getPhoneNumber());

            userRepo.save(user);
            System.out.println("User has been updated");
        }else{
            return "User Id is not found";
        }

        return null;
    }



}
