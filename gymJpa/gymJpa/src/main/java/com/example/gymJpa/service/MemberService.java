package com.example.gymJpa.service;

import com.example.gymJpa.model.Gym;
import com.example.gymJpa.model.Member;
import com.example.gymJpa.model.Trainer;
import com.example.gymJpa.repository.GymRepository;
import com.example.gymJpa.repository.MemberRepository;
import com.example.gymJpa.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    GymService gymService;

    public Member findMemberWhichTrainByMostTrainer() {
        List<Member> members = memberRepository.findAll();
        Member finalmember = null;
        int max =0;
        for(Member member:members){
            if(member.getTrainersList().size()>max){
                max = member.getTrainersList().size();
                finalmember = member;
            }
        }
        return finalmember;
    }

    public Member findMemberWhichTrainByLeastTrainer() {
        return null;
    }

    public Member findMemberWhichTrainedByATrainerWhoseWorksInMoreThanOneGym() {
        return null;
    }

    public String addMember(Member member) {
        if(member !=null){
            memberRepository.save(member);
            return "Success";
        }
        return "Unsuccessful";
    }

    public String giveMeTrainer(int memberId, int trainerId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(optionalMember.isPresent()){
            Member member = optionalMember.get();
            Gym gym = member.getGym();
            if(gym !=null){
                int gymId = gym.getGymId();
                Trainer trainer = gymService.findTrainerInParticularGym(trainerId , gymId);
                if(trainer != null){
                    if(trainer.getTrainerId() == trainerId){
                        member.getTrainersList().add(trainer);
                        trainer.getMembersList().add(member);
                        memberRepository.save(member);
                        trainerRepository.save(trainer);
                        return "Successfully I Give You Trainer";
                    }else{
                        return "Failed To Give You Trainer";
                    }
                }else{
                    return "Failed To Give You Trainer";
                }
            }else{
                return "Failed To Give You Trainer";
            }
        }
        return "Failed To Give You Trainer";
    }
}
