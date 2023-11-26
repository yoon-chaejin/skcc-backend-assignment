package com.example.skccbackendassignment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.skccbackendassignment.dto.MemberRequest;
import com.example.skccbackendassignment.entity.Member;
import com.example.skccbackendassignment.service.MemberService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping()
    public Page<Member> findMemberByPage(Pageable pageable) {
        return memberService.findMemberByPage(pageable);
    }

    @GetMapping("/{id}")
    public Member findMemberById(@PathVariable("id") Long id) {
        return memberService.findMemberById(id);
    }

    @PostMapping
    public Member registerMember(@RequestBody MemberRequest memberRequest) {
        Member member = Member.of(memberRequest);
        return memberService.register(member);
    }
}
