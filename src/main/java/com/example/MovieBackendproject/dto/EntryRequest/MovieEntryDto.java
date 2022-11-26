package com.example.MovieBackendproject.dto.EntryRequest;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MovieEntryDto {
    String name;
    LocalDate releaseDate;
}
