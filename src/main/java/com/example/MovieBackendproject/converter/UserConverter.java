package com.example.MovieBackendproject.converter;

import com.example.MovieBackendproject.Model.UserEntity;
import com.example.MovieBackendproject.dto.EntryRequest.UserEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.UserResponseDto;

public class UserConverter {
    public static UserEntity convertDtoEntity(UserEntryDto userdto){
        return UserEntity.builder().name(userdto.getName()).mobileNo(userdto.getMobileNo()).build();
    }
    
    public static UserResponseDto convertEntityToDto(UserEntity user){
        return UserResponseDto.builder().id(user.getId()).name(user.getName())
                .mobNo(user.getMobileNo()).build();
    }
}
