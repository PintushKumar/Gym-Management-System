package com.example.gymJpa.controller;

import com.example.gymJpa.model.Member;
import com.example.gymJpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @PostMapping("/addMember")
    public String addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }
    @PostMapping("/giveMeTrainer")
    public String giveMeTrainer(@RequestParam int memberId , @RequestParam int trainerId ){
        return memberService.giveMeTrainer(memberId, trainerId);
    }
    @GetMapping("/findMemberWhichTrainByMostTrainer")
    public Member findMemberWhichTrainByMostTrainer(){
        return memberService.findMemberWhichTrainByMostTrainer();
    }
    @GetMapping("/findMemberWhichTrainByLeastTrainer")
    public Member findMemberWhichTrainByLeastTrainer(){
        return memberService.findMemberWhichTrainByLeastTrainer();
    }
    @GetMapping("/findMemberWhichTrainedByATrainerWhoseWorksInMoreThanOneGym")
    public Member findMemberWhichTrainedByATrainerWhoseWorksInMoreThanOneGym(){
        return memberService.findMemberWhichTrainedByATrainerWhoseWorksInMoreThanOneGym();
    }
}
