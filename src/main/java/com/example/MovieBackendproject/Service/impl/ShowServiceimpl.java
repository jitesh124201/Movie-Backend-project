package com.example.MovieBackendproject.Service.impl;

import com.example.MovieBackendproject.Model.*;
import com.example.MovieBackendproject.Repository.MovieRepository;
import com.example.MovieBackendproject.Repository.ShowRepository;
import com.example.MovieBackendproject.Repository.ShowSeatsRepository;
import com.example.MovieBackendproject.Repository.TheaterRepository;
import com.example.MovieBackendproject.Service.ShowService;
import com.example.MovieBackendproject.converter.MovieConverter;
import com.example.MovieBackendproject.converter.ShowConverter;
import com.example.MovieBackendproject.converter.TheaterConverter;
import com.example.MovieBackendproject.dto.EntryRequest.ShowEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.MovieResponseDto;
import com.example.MovieBackendproject.dto.ResponseDto.ShowResponseDto;
import com.example.MovieBackendproject.dto.ResponseDto.TheaterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ShowServiceimpl implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheatreEntity theatreEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theatreEntity);
        showEntity = showRepository.save(showEntity);
        generateShowEntitySeats(theatreEntity.getSeats(),showEntity);


        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);
        return showResponseDto;

    }

    public void generateShowEntitySeats(List<TheatreSeatEntity> theatreSeatEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();


        for(TheatreSeatEntity tse: theatreSeatEntityList){
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }


        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }
        showSeatsRepository.saveAll(showSeatsEntityList);
        showEntity.setSeats(showSeatsEntityList);
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity = showRepository.findById(id).get();
        MovieEntity movieEntity = movieRepository.findById(showEntity.getMovie().getId()).get();
        TheatreEntity theatreEntity = theaterRepository.findById(showEntity.getTheater().getId()).get();
        MovieResponseDto movieResponseDto = MovieConverter.convertEntitytoDto(movieEntity);
        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theatreEntity);

        ShowEntryDto showEntryDto = ShowEntryDto.builder().showDate(showEntity.getShowdate()).showTime(showEntity.getShowTime()).movieResponseDto(movieResponseDto).theaterResponseDto(theaterResponseDto).build();
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);
        return showResponseDto;
    }
}
