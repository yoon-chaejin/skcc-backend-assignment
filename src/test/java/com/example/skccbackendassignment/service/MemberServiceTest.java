package com.example.skccbackendassignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.skccbackendassignment.entity.Member;

@SpringBootTest
public class MemberServiceTest {
    
    @Autowired
    private MemberService memberService;

    @Test
    void testRegister() {
        // given
        Member member = new Member(null, "길동", "홍", "주소", "20231126", null);

        // when
        Object object = memberService.register(member);

        // then
        assertInstanceOf(Member.class, object);
    }

    @Test
    void testFindMemberById() {
        // given
        Member memberBeforeRegister = new Member(null, "길동", "홍", "주소", "20231126", null);
        Member memberAfterRegister = memberService.register(memberBeforeRegister);

        // when
        Member member = memberService.findMemberById(memberAfterRegister.getId());

        // then
        assertEquals(memberBeforeRegister.getFirstName(), member.getFirstName());
        assertEquals(memberBeforeRegister.getLastName(), member.getLastName());
        assertEquals(memberBeforeRegister.getAddress(), member.getAddress());
    }

    @Test
    void testFindMemberByPageGiven7MembersAndPageableOfSize5() {
        // given
        for (int i=0; i<7; i++) {
            Member member = new Member(null, "길동", "홍", "주소", "20231126", null);
            memberService.register(member);
        }

        // when
        Pageable pageableOne = Pageable.ofSize(5);
        Page<Member> resultOne = memberService.findMemberByPage(pageableOne);
        
        Pageable pageableTwo = pageableOne.next();
        Page<Member> resultTwo = memberService.findMemberByPage(pageableTwo);

        Pageable pageableThree = pageableTwo.next();
        Page<Member> resultThree = memberService.findMemberByPage(pageableThree);


        // then
        assertEquals(5, resultOne.getNumberOfElements());
        assertEquals(2, resultTwo.getNumberOfElements());
        assertEquals(0, resultThree.getNumberOfElements());
    }
}
