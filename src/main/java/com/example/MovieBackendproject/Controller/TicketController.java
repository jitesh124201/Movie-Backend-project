package com.example.MovieBackendproject.Controller;

import com.example.MovieBackendproject.Service.impl.TicketServiceimpl;
import com.example.MovieBackendproject.dto.BookTicketRequestDto;
import com.example.MovieBackendproject.dto.ResponseDto.TicketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    TicketServiceimpl ticketServiceimpl;

    @PostMapping("/book-ticket")
    public ResponseEntity<TicketResponseDto> addTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){
        TicketResponseDto ticketResponseDto = ticketServiceimpl.bookTicket(bookTicketRequestDto);
        return new ResponseEntity<>(ticketResponseDto, HttpStatus.CREATED);
    }

}
