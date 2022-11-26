package com.example.MovieBackendproject.Service;

import com.example.MovieBackendproject.dto.EntryRequest.UserEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.UserResponseDto;

public interface UserService {

    void addUser(UserEntryDto userdto);

    UserResponseDto getUser(int id);


}
