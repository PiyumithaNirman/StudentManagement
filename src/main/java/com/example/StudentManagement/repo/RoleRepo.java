package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role getAllByRoleName(String roleName);

    boolean existsByRoleId(int roleId);
}
