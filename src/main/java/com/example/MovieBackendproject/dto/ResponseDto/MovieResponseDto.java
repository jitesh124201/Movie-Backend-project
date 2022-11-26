package com.example.MovieBackendproject.dto.ResponseDto;

import com.example.MovieBackendproject.dto.Showdto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {
    int id;
    String name;
    LocalDate releaseDate;

    List<ShowResponseDto> showDtoDetail;
}
