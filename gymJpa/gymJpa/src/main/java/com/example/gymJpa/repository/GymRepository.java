package com.example.gymJpa.repository;

import com.example.gymJpa.model.Gym;
import com.example.gymJpa.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface GymRepository extends JpaRepository<Gym , Integer> {
    @Query("SELECT t FROM Trainer t JOIN t.gymList g WHERE t.trainerId = :trainerId")
    Trainer findTrainerByTrainerId(@RequestParam("trainerId") int trainerId);
    @Query("SELECT g FROM Gym g JOIN g.trainerList t WHERE t.trainerId = :trainerId")
    Gym findGymByTrainerId(@RequestParam("trainerId") int trainerId);
//    @Query("SELECT t.* FROM Trainer t JOIN trainer_gyms tg ON t.trainerId = tg.trainerId WHERE tg.trainerId = :trainerId AND tg.gymId = :gymId")
//    Trainer findTrainerInParticularGym(int trainerId , int gymId);
    @Query("SELECT t FROM Trainer t JOIN t.gymList g WHERE t.trainerId = :trainerId AND g.gymId = :gymId")
    Trainer findTrainerInParticularGym(int trainerId, int gymId);
}
