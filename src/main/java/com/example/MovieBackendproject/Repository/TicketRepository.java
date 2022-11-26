package com.example.MovieBackendproject.Repository;

import com.example.MovieBackendproject.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {

}
