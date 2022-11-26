package com.example.MovieBackendproject.Controller;

import com.example.MovieBackendproject.Service.impl.MovieServiceimpl;
import com.example.MovieBackendproject.dto.EntryRequest.MovieEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieServiceimpl movieServiceimpl;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){
        movieServiceimpl.addmovie(movieEntryDto);
        return new ResponseEntity<>("Movie Added", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity<MovieResponseDto> getMovie(@PathVariable int id){
        MovieResponseDto movieResponseDto = movieServiceimpl.getMovie(id);
        return new ResponseEntity<>(movieResponseDto,HttpStatus.OK);
    }

}
