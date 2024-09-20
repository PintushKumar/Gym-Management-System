package com.example.gymJpa.service;

import com.example.gymJpa.model.Trainer;
import com.example.gymJpa.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;
    public String addTrainer(Trainer trainer) {
        if(trainer!=null){
            trainerRepository.save(trainer);
            return "Trainer added successfully";
        }
        return "Unsuccessful";
    }

    public int findNumberOfTrainersWhoWorkInMoreThanFiveGyms() {
        return 0;
    }
}
