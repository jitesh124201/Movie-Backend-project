package com.example.MovieBackendproject.Service;

import com.example.MovieBackendproject.dto.EntryRequest.ShowEntryDto;
import com.example.MovieBackendproject.dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);
    ShowResponseDto getShow(int id);

}
