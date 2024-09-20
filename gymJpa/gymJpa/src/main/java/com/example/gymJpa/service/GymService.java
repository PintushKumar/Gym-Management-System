package com.example.gymJpa.service;

import com.example.gymJpa.model.Gym;
import com.example.gymJpa.model.Member;
import com.example.gymJpa.model.Trainer;
import com.example.gymJpa.repository.GymRepository;
import com.example.gymJpa.repository.MemberRepository;
import com.example.gymJpa.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymService {
    @Autowired
    GymRepository gymRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    MemberRepository memberRepository;
    public String addGym(Gym gym) {
        if(gym!=null){
            gymRepository.save(gym);
            return "Success";
        }
        return "Unsuccessful";
    }

    public String addTrainerInGym(int trainerId, int gymId) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
        Optional<Gym> optionalGym = gymRepository.findById(gymId);
        if(optionalTrainer.isPresent() && optionalGym.isPresent()){
            Trainer trainer = optionalTrainer.get();
            Gym gym = optionalGym.get();
            gym.getTrainerList().add(trainer);
            trainer.getGymList().add(gym);
            gymRepository.save(gym);
            trainerRepository.save(trainer);
            return "Success";
        }
        return "Unsuccessful";
    }

    public Gym findGymWithMostNumberOfMembers() {
        return null;
    }

    public String addMemberInGym(int memberId, int gymId) {
        Optional<Gym> optionalGym = gymRepository.findById(gymId);
        Optional<Member>optionalMember = memberRepository.findById(memberId);
        if (optionalMember.isPresent() && optionalGym.isPresent()) {
            Gym gym = optionalGym.get();
            Member member = optionalMember.get();
            gym.getMemberList().add(member);
            member.setGym(gym);
            gymRepository.save(gym);
            memberRepository.save(member);
            return "Success";
        }
        return "Unsuccessful";
    }

    public Trainer findTrainerInParticularGym(int trainerId , int gymId ){
        Optional<Trainer> optionalTrainer = Optional.ofNullable(gymRepository.findTrainerInParticularGym(trainerId, gymId));
        return optionalTrainer.orElse(null);
    }
}
