package com.example.MovieBackendproject.Repository;

import com.example.MovieBackendproject.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
