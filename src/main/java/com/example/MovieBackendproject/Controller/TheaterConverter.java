package com.example.MovieBackendproject.Controller;

import com.example.MovieBackendproject.Service.impl.TheaterServiceimpl;
import com.example.MovieBackendproject.dto.EntryRequest.TheaterEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("theater")
public class TheaterConverter {
    @Autowired
    TheaterServiceimpl theaterServiceimpl;

    @PostMapping("/add-theater")
    public ResponseEntity<String> addtheater(@RequestBody  TheaterEntryDto theaterEntryDto){
        theaterServiceimpl.addTheater(theaterEntryDto);
        return new ResponseEntity<>("Theater Added Succesfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-theater/{id}")
    public ResponseEntity<TheaterResponseDto> getTheater(@PathVariable int id){
        TheaterResponseDto theaterResponseDto = theaterServiceimpl.getTheater(id);
        return new ResponseEntity<>(theaterResponseDto,HttpStatus.OK);
    }
}
