package com.example.MovieBackendproject.dto.EntryRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterEntryDto {
   String name;
   String city;
   String address;
}
