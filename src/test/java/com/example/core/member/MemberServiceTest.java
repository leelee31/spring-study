package com.example.core.member;

import com.example.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "sumin", Grade.BASIC);
        //when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);
        //then
        Assertions.assertEquals(member1, member);
    }
}
