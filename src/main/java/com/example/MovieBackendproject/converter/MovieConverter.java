package com.example.MovieBackendproject.converter;

import com.example.MovieBackendproject.Model.MovieEntity;
import com.example.MovieBackendproject.dto.EntryRequest.MovieEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.MovieResponseDto;

public class MovieConverter {

    public static MovieEntity convertdtoToEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder().name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate())
                .build();
    }
    public static MovieResponseDto convertEntitytoDto(MovieEntity movieEntity){
        return MovieResponseDto.builder().id(movieEntity.getId())
                .releaseDate(movieEntity.getReleaseDate())
                .name(movieEntity.getName())
                .build();
    }
}
