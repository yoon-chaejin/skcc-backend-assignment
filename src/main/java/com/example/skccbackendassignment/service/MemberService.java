package com.example.skccbackendassignment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.skccbackendassignment.entity.Member;
import com.example.skccbackendassignment.repository.MemberRepository;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<Member> findMemberByPage(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    public Member findMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    public Member register(Member member) {
        return memberRepository.save(member);
    }
}
