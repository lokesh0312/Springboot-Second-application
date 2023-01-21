package com.example.secondapp.secondapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jersey;
    @Column(name="First_Name", nullable = false)
    private String firstName;
    @Column(name="Last_Name", nullable = false)

    private String lastName;
    @Column(name="Team_Name", nullable = false)

    private String teamName;
}
