package com.example.MovieBackendproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "release_date",columnDefinition = "date",nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;
}
