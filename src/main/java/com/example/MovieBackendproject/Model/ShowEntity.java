package com.example.MovieBackendproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shows")
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date",columnDefinition = "DATE",nullable = false)
   private LocalDate showdate;

    @Column(name = "show_time",columnDefinition = "TIME",nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JsonIgnore
    private MovieEntity movie;

    @ManyToOne
    @JsonIgnore
    private TheatreEntity theater;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;
}
