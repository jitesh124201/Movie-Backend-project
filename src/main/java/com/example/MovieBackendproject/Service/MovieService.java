package com.example.MovieBackendproject.Service;

import com.example.MovieBackendproject.dto.EntryRequest.MovieEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    MovieResponseDto addmovie(MovieEntryDto movieEntryDto);
    MovieResponseDto getMovie(int id);
}
