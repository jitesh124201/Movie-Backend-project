package com.example.MovieBackendproject.Service;

import com.example.MovieBackendproject.dto.EntryRequest.TheaterEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {
    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);
    TheaterResponseDto getTheater(int id);
}
