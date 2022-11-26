package com.example.MovieBackendproject.Service.impl;

import com.example.MovieBackendproject.Model.TheatreEntity;
import com.example.MovieBackendproject.Model.TheatreSeatEntity;
import com.example.MovieBackendproject.Repository.TheaterRepository;
import com.example.MovieBackendproject.Repository.TheaterSeatRepository;
import com.example.MovieBackendproject.Service.TheaterService;
import com.example.MovieBackendproject.converter.TheaterConverter;
import com.example.MovieBackendproject.dto.EntryRequest.TheaterEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.TheaterResponseDto;
import com.example.MovieBackendproject.enums.SeatType;
import com.example.MovieBackendproject.enums.TheaterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheaterServiceimpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Override
    public TheaterResponseDto getTheater(int id) {
        TheatreEntity theatreEntity = theaterRepository.findById(id).get();
        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theatreEntity);
        return theaterResponseDto;
    }
    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {
        TheatreEntity theatreEntity = TheaterConverter.ConvertDtotoEntity(theaterEntryDto);

        List<TheatreSeatEntity> seats = createTheaterSeats();

        theatreEntity.setSeats(seats);
        theatreEntity.setShows(null);
        theatreEntity.setType(TheaterType.SINGLE);

        for(TheatreSeatEntity theatreSeatEntity:seats){
            theatreSeatEntity.setTheater(theatreEntity);
        }

        theatreEntity = theaterRepository.save(theatreEntity);
        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theatreEntity);

        return theaterResponseDto;
    }
    List<TheatreSeatEntity> createTheaterSeats(){
        List<TheatreSeatEntity> seats = new ArrayList<>();
        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("2A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("3A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("4A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("5A",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("1B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("3B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("4B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("5B",100,SeatType.PREMIUM));

        theaterSeatRepository.saveAll(seats);
        return seats;

    }
    TheatreSeatEntity getTheaterSeat(String seatName, int rate, SeatType seatType){
        return TheatreSeatEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }


}
