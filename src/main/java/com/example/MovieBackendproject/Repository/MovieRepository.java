package com.example.MovieBackendproject.Repository;

import com.example.MovieBackendproject.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    boolean existsByName(String name);
}
