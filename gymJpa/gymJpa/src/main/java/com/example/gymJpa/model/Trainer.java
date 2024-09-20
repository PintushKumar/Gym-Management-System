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
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int trainerId ;
    private String name ;
    @ManyToMany
    @JoinTable(
            name = "trainer_members",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> membersList;
    @ManyToMany
    @JoinTable(
            name = "trainer_gyms",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id")
    )
    private List<Gym> gymList;
}
