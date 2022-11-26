package com.example.MovieBackendproject.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "mobile",nullable = false)
    private String mobileNo;

    //this is the pending part
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL) // default thing
    @JsonIgnore
    private List<TicketEntity> listOfTicket;
}
