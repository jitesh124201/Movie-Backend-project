package com.example.MovieBackendproject.Service.impl;

import com.example.MovieBackendproject.Model.ShowEntity;
import com.example.MovieBackendproject.Model.ShowSeatsEntity;
import com.example.MovieBackendproject.Model.TicketEntity;
import com.example.MovieBackendproject.Model.UserEntity;
import com.example.MovieBackendproject.Repository.ShowRepository;
import com.example.MovieBackendproject.Repository.TicketRepository;
import com.example.MovieBackendproject.Repository.UserRepository;
import com.example.MovieBackendproject.Service.TicketService;
import com.example.MovieBackendproject.converter.TicketConverter;
import com.example.MovieBackendproject.dto.BookTicketRequestDto;
import com.example.MovieBackendproject.dto.ResponseDto.TicketResponseDto;
import com.example.MovieBackendproject.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceimpl implements TicketService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();
        TicketResponseDto ticketResponseDto = TicketConverter.ConvertEntityToDto(ticketEntity);
        return ticketResponseDto;
    }
    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        UserEntity user = userRepository.findById(bookTicketRequestDto.getUserId()).get();
        ShowEntity show = showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();
        List<ShowSeatsEntity> showseatList = show.getSeats();

        List<ShowSeatsEntity> availableSeats = showseatList.stream()
                .filter(seats -> seats.getSeatType().equals(bookTicketRequestDto.getSeatType()) && !seats.isBooked() &&
                        requestedSeats.contains(seats.getSeatNumber())).collect(Collectors.toList());

        if(availableSeats.size()!=requestedSeats.size()){
            throw new Error("All seats are not available");
        }

        TicketEntity ticket = TicketEntity.builder().user(user).show(show).seats(availableSeats).build();
        double amount = 0;
        for(ShowSeatsEntity seats:availableSeats){
            seats.setBooked(true);
            seats.setBookedAt(new Date());
            seats.setTicket(ticket);
            seats.setShow(show);
            amount+=seats.getRate();
        }
        ticket.setAmount(amount);
        ticket.setAllotedSeats(ConvertListOpSeatsToString(availableSeats));
        ticket.setBookedAt(new Date());

        user.getListOfTicket().add(ticket);
        show.getTickets().add(ticket);
        ticket = ticketRepository.save(ticket);
        return TicketConverter.ConvertEntityToDto(ticket);
    }
    public String ConvertListOpSeatsToString(List<ShowSeatsEntity> bookSeat){
        String str="";
        for(ShowSeatsEntity showSeats:bookSeat){
            str = str + showSeats.getSeatNumber()+" ";
        }
        return str;
    }
}
