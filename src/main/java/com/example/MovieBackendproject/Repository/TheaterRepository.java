package com.example.MovieBackendproject.Repository;

import com.example.MovieBackendproject.Model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheatreEntity,Integer> {
}
