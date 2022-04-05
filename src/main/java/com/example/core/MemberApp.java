package com.example.core;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService ms = appConfig.memberService();
        Member member = new Member(1L, "sumin", Grade.VIP); // cmd + option + v
        ms.join(member);

        Member member1 = ms.findMember(1L);

        System.out.println("new member: " + member.getName());
        System.out.println("find member: " +member1.getName());
    }
}
