package com.example.MovieBackendproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alloted_seats",nullable = false)
    private String allotedSeats;

    @Column(name = "amount",nullable = false)
    private double amount;


    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at",nullable = false)
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;
}
