package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
