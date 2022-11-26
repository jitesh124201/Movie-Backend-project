package com.example.MovieBackendproject.converter;

import com.example.MovieBackendproject.Model.MovieEntity;
import com.example.MovieBackendproject.Model.ShowEntity;
import com.example.MovieBackendproject.dto.EntryRequest.ShowEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.ShowResponseDto;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){
        return ShowEntity.builder().showdate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .build();
    }
    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity,ShowEntryDto showEntryDto){
        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showDate(showEntity.getShowdate())
                .showTime(showEntity.getShowTime())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterResponseDto(showEntryDto.getTheaterResponseDto())
                .build();

    }
}
