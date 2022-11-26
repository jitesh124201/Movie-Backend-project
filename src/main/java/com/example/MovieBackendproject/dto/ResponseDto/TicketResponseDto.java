package com.example.MovieBackendproject.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    int id;
    String allotedSeats;
    double amount;
}
