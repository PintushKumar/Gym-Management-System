package com.example.gymJpa.repository;

import com.example.gymJpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member , Integer> {
}
