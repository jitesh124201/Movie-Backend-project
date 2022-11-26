package com.example.MovieBackendproject.dto;

import com.example.MovieBackendproject.enums.SeatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookTicketRequestDto {

    int userId;
    int showId;
    Set<String> requestedSeats;
    SeatType seatType;

}
