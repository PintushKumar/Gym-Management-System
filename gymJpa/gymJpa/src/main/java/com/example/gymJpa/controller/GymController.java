package com.example.gymJpa.controller;

import com.example.gymJpa.model.Gym;
import com.example.gymJpa.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gym")
public class GymController {
    @Autowired
    private GymService gymService;
    @PostMapping("/addGym")
    public String addGym(@RequestBody Gym gym){
        return gymService.addGym(gym);
    }
    @PostMapping("/addTrainerInGym")
    public String addTrainerInGym(@RequestParam int trainerId , @RequestParam int gymId){
        return gymService.addTrainerInGym(trainerId , gymId);
    }

    @PostMapping("/addMemberInGym")
    public String addMemberInGym(@RequestParam int memberId, @RequestParam int gymId){
        return gymService.addMemberInGym(memberId, gymId);
    }


    @GetMapping("/findGymWithMostNumberOfMembers")
    public Gym findGymWithMostNumberOfMembers(){
        return gymService.findGymWithMostNumberOfMembers();
    }


}
