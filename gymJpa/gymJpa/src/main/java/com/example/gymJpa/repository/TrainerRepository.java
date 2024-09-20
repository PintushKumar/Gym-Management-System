package com.example.gymJpa.repository;

import com.example.gymJpa.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer , Integer> {
}
