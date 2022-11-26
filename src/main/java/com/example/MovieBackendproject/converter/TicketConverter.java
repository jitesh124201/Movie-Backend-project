package com.example.MovieBackendproject.converter;

import com.example.MovieBackendproject.Model.TicketEntity;
import com.example.MovieBackendproject.dto.ResponseDto.TicketResponseDto;
import com.example.MovieBackendproject.dto.Ticketdto;

public class TicketConverter {
    public static TicketEntity ConvertDtotoEntity(Ticketdto ticketdto){
        return TicketEntity.builder().allotedSeats(ticketdto.getAllotedSeats())
                .amount(ticketdto.getAmount()).build();
    }

    public static TicketResponseDto ConvertEntityToDto(TicketEntity ticketEntity){
        return TicketResponseDto.builder().id(ticketEntity.getId())
                .amount(ticketEntity.getAmount())
                .allotedSeats(ticketEntity.getAllotedSeats())
                .build();
    }
}
