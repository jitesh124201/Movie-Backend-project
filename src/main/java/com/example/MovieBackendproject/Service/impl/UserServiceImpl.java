package com.example.MovieBackendproject.Service.impl;

import com.example.MovieBackendproject.Model.UserEntity;
import com.example.MovieBackendproject.Repository.UserRepository;
import com.example.MovieBackendproject.Service.UserService;
import com.example.MovieBackendproject.converter.UserConverter;
import com.example.MovieBackendproject.dto.EntryRequest.UserEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userdto) {
        UserEntity userEntity = UserConverter.convertDtoEntity(userdto);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserResponseDto userdto = UserConverter.convertEntityToDto(userEntity);
        return userdto;
    }
}
