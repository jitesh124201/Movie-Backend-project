package com.example.MovieBackendproject.Controller;

import com.example.MovieBackendproject.Service.impl.ShowServiceimpl;
import com.example.MovieBackendproject.dto.EntryRequest.ShowEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceimpl showServiceimpl;

    @PostMapping("/add-show")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        showServiceimpl.addShow(showEntryDto);
        return new ResponseEntity<>("Show Added", HttpStatus.CREATED);
    }

    @GetMapping("/get-show/{id}")
    public ResponseEntity<ShowResponseDto> getshow(@PathVariable int id){
        ShowResponseDto showResponseDto = showServiceimpl.getShow(id);
        return new ResponseEntity<>(showResponseDto,HttpStatus.ACCEPTED);
    }


}
