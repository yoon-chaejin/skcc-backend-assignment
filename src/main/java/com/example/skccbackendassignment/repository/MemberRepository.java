package com.example.skccbackendassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skccbackendassignment.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
