package com.example.gymJpa.controller;

import com.example.gymJpa.model.Trainer;
import com.example.gymJpa.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    @PostMapping("/addTrainer")
    public String addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }
    @GetMapping("/findNumberOfTrainersWhoWorkInMoreThanFiveGyms")
    public int findNumberOfTrainersWhoWorkInMoreThanFiveGyms() {
        return trainerService.findNumberOfTrainersWhoWorkInMoreThanFiveGyms();
    }

}
