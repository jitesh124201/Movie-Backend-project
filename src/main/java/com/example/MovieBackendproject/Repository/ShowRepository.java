package com.example.MovieBackendproject.Repository;

import com.example.MovieBackendproject.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
