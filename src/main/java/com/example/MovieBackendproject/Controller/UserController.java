package com.example.MovieBackendproject.Controller;

import com.example.MovieBackendproject.Service.impl.UserServiceImpl;
import com.example.MovieBackendproject.dto.EntryRequest.UserEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){
        userService.addUser(userEntryDto);
        return new ResponseEntity<>("Succesfully Added", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id){
        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.ACCEPTED);
    }
}
