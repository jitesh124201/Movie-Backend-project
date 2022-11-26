package com.example.MovieBackendproject.Repository;

import com.example.MovieBackendproject.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
