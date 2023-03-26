package com.example.StudentManagement.controller;

import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.repo.RoleRepo;
import com.example.StudentManagement.repo.UserRepo;
import com.example.StudentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@Transactional
public class PostConstructController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void saveAdmin(){

            Role role = new Role();
            role.setRoleId(1);
            role.setRoleName("Admin");
            role.setDescription("Admin");

        if (!roleRepo.existsById(role.getRoleId())) {

            roleRepo.save(role);
            System.out.println("Successfully create new role");

        }else {
            System.out.println("Role has already been added");
        }

            User user = new User();
            user.setUserId(1);
            user.setFirstName("Piyumitha");
            user.setLastName("Nirman");
            user.setPassword(passwordEncoder.encode("Piyu1234"));
            user.setUserName("piyumithanirman@gmail.com");
//            user.setPhoneNumber(new ArrayList<>(Collections.singleton("0702453043")));
            user.setPhoneNumber("+94702453043");
            user.setAge(22);
            user.setActiveState(true);

            Set<Role> roles = new HashSet<>();
            roles.add(role);

            user.setRole(roles);

            boolean adminUserName = userRepo.existsByUserName(user.getUserName());

            if (!adminUserName) {
                userRepo.save(user);
            } else {
                System.out.println("User has already been saved");
            }
    }
}
