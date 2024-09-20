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
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int memberId;
    private String name;
    private String email;
    @ManyToMany(mappedBy = "membersList" , cascade = CascadeType.ALL)
    private List<Trainer> trainersList;
    @ManyToOne
    private Gym gym;
}
