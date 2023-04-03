package com.example.StudentManagement.repo;

import com.example.StudentManagement.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ImageRepository extends JpaRepository<ImageData,Integer> {

    ImageData getByUserUserId(int id);

}
