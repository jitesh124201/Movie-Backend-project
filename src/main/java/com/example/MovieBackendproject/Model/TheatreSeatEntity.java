package com.example.MovieBackendproject.Model;

import com.example.MovieBackendproject.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "theater_seats")
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number",nullable = false)
    private String seatNumber;

    @Column(name="rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theater;
}
