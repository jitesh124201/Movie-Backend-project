package com.example.MovieBackendproject.Model;

import com.example.MovieBackendproject.enums.SeatType;
import com.example.MovieBackendproject.enums.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "theatre")
public class TheatreEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @Column(name = "name",nullable = false)
     private String name;

     @Column(name = "city",nullable = false)
     private String city;

     @Column(name = "address",nullable = false)
    private String address;

     @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
     @JsonIgnore
    private List<ShowEntity> shows;

     @Enumerated(EnumType.STRING)
     @Column(name = "type",nullable = false)
     private TheaterType type;

     @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
     @JsonIgnore
    private List<TheatreSeatEntity> seats;
}
