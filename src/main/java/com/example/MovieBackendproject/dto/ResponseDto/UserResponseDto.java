package com.example.MovieBackendproject.dto.ResponseDto;

import com.example.MovieBackendproject.dto.Ticketdto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class UserResponseDto {
    int id;
    String name;
    String mobNo;
    List<Ticketdto> tickets;
}
