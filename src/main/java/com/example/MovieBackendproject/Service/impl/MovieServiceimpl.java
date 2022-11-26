package com.example.MovieBackendproject.Service.impl;

import com.example.MovieBackendproject.Model.MovieEntity;
import com.example.MovieBackendproject.Repository.MovieRepository;
import com.example.MovieBackendproject.Service.MovieService;
import com.example.MovieBackendproject.converter.MovieConverter;
import com.example.MovieBackendproject.dto.EntryRequest.MovieEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceimpl implements MovieService {
@Autowired
MovieRepository movieRepository;


    @Override
    public MovieResponseDto addmovie(MovieEntryDto movieEntryDto) {

        MovieResponseDto movieResponseDto = null;

        //if the movie is already created then we can throw an exception....movie already exists.
        if(movieRepository.existsByName(movieEntryDto.getName())){

            movieResponseDto.setName("This movie is already Existing");
            return movieResponseDto;
        }

        log.info("In the function add movie "+ movieEntryDto);


        MovieEntity movieEntity = MovieConverter.convertdtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);

         movieResponseDto = MovieConverter.convertEntitytoDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
       MovieEntity movieEntity = movieRepository.findById(id).get();
       MovieResponseDto movieResponseDto = MovieConverter.convertEntitytoDto(movieEntity);
       return movieResponseDto;
    }
}
