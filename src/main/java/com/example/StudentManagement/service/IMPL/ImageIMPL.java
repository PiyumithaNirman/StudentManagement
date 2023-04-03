package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.entity.ImageData;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.repo.ImageRepository;
import com.example.StudentManagement.repo.UserRepo;
import com.example.StudentManagement.service.ImageService;
import com.example.StudentManagement.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageIMPL implements ImageService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ImageRepository imageRepository;
    @Override
    public String uploadImage(MultipartFile file, int id) throws IOException {

        User user = userRepo.getById(id);

        if(!file.isEmpty()){
            ImageData imageData = new ImageData(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    ImageUtils.compressImage(file.getBytes()),
                    user
            );

            imageRepository.save(imageData);

            return file.getOriginalFilename() + " Image is uploaded";
        }

        return null;
    }

    @Override
    public byte[] downloadImage(int id) {

            ImageData imageData = imageRepository.getByUserUserId(id);

            if(imageData.getUser().getUserId() == id) {

                byte[] bytes = ImageUtils.decompressImage(imageData.getImageData());

                System.out.println("Image is found");
                return bytes;
            }else

                System.out.println("Image is not found with this user");
                return null;
        }
}
