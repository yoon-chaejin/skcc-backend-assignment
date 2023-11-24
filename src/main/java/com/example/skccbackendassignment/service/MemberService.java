package com.example.skccbackendassignment.service;

import org.springframework.stereotype.Service;

import com.example.skccbackendassignment.entity.Member;
import com.example.skccbackendassignment.repository.MemberRepository;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    public Member register(Member member) {
        return memberRepository.save(member);
    }
}
