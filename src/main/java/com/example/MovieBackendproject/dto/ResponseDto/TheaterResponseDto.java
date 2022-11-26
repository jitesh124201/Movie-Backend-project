package com.example.MovieBackendproject.dto.ResponseDto;

import com.example.MovieBackendproject.enums.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterResponseDto {
    int id;
    String name;
    String city;
    String address;
    TheaterType type;
}
