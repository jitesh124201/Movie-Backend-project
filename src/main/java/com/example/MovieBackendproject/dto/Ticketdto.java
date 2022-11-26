package com.example.MovieBackendproject.dto;

import com.example.MovieBackendproject.dto.ResponseDto.ShowResponseDto;
import com.example.MovieBackendproject.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class Ticketdto {
    int id;
    String allotedSeats;
    double amount;

    @NotNull
    UserResponseDto userDto;

    ShowResponseDto showDto;
}
