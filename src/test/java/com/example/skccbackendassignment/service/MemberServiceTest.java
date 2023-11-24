package com.example.skccbackendassignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.skccbackendassignment.entity.Member;

@SpringBootTest
public class MemberServiceTest {
    
    @Autowired
    private MemberService memberService;

    @Test
    void testRegister() {
        // given
        Member member = new Member(null, "길동", "홍", "주소", null, null);

        // when
        Object object = memberService.register(member);

        // then
        assertInstanceOf(Member.class, object);
    }

    @Test
    void testFindMemberById() {
        // given
        Member memberBeforeRegister = new Member(null, "길동", "홍", "주소", null, null);
        Member memberAfterRegister = memberService.register(memberBeforeRegister);

        // when
        Member member = memberService.findMemberById(memberAfterRegister.getId());

        // then
        assertEquals(memberBeforeRegister.getFirstName(), member.getFirstName());
        assertEquals(memberBeforeRegister.getLastName(), member.getLastName());
        assertEquals(memberBeforeRegister.getAddress(), member.getAddress());
    }
}
