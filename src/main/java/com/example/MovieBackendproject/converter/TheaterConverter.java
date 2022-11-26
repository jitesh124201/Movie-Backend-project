package com.example.MovieBackendproject.converter;

import com.example.MovieBackendproject.Model.TheatreEntity;
import com.example.MovieBackendproject.dto.EntryRequest.TheaterEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.TheaterResponseDto;

public class TheaterConverter {

    public static TheatreEntity ConvertDtotoEntity(TheaterEntryDto theaterEntryDto){
        return TheatreEntity.builder().name(theaterEntryDto.getName())
                .city(theaterEntryDto.getCity())
                .address(theaterEntryDto.getAddress())
                .build();
    }
    public static TheaterResponseDto convertEntityToDto(TheatreEntity theatreEntity){
        return TheaterResponseDto.builder().id(theatreEntity.getId())
                .name(theatreEntity.getName())
                .city(theatreEntity.getCity())
                .address(theatreEntity.getAddress())
                .type(theatreEntity.getType())
                .build();
    }
}
