package com.example.MovieBackendproject.Service;

import com.example.MovieBackendproject.dto.BookTicketRequestDto;
import com.example.MovieBackendproject.dto.ResponseDto.TicketResponseDto;
import com.example.MovieBackendproject.dto.Ticketdto;

public interface TicketService {

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
    TicketResponseDto getTicket(int id);
}
