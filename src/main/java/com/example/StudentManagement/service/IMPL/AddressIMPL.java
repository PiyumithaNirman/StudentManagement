package com.example.StudentManagement.service.IMPL;

import com.example.StudentManagement.dto.AddressDTO;
import com.example.StudentManagement.entity.Address;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.exception.NotFoundException;
import com.example.StudentManagement.repo.AddressRepo;
import com.example.StudentManagement.repo.UserRepo;
import com.example.StudentManagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressIMPL implements AddressService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AddressRepo addressRepo;
    @Override
    public String saveAddress(AddressDTO addressDTO) {

        User user = userRepo.getById(addressDTO.getUserId());

        if(userRepo.existsById(addressDTO.getUserId())){

            Address address = new Address(
                    addressDTO.getStreet(),
                    addressDTO.getCity(),
                    addressDTO.getState(),
                    addressDTO.getZipCode(),
                    user
            );

            addressRepo.save(address);
            return "Address has been saved";
        }else
            throw new NotFoundException("User is not found");
    }
}
