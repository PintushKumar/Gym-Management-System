package com.example.gymJpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gymId;
    private String location;
    @OneToMany(mappedBy = "gym")
    private List<Member> memberList;
    @ManyToMany(mappedBy = "gymList" ,cascade = CascadeType.ALL)
    private List<Trainer> trainerList;
}
