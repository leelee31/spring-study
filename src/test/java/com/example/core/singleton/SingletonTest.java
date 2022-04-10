package com.example.core.singleton;

import com.example.core.AppConfig;
import com.example.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer () {
        AppConfig ac = new AppConfig();
        MemberService memberService = ac.memberService();

        MemberService memberService1 = ac.memberService();

        MemberService memberService2 = ac.memberService();

        Assertions.assertNotSame(memberService2, memberService);

        // 객체가 계속 생성된다 - 참조값이 다름
    }

    @Test
    @DisplayName("object using singleton pattern")
    void singletonServiceTest () {
       // new SingletonServiceTest(); -> has private access in 'com.example.core.singleton.SingletonServiceTest'
        SingletonServiceTest instance = SingletonServiceTest.getInstance();
        SingletonServiceTest instance1 = SingletonServiceTest.getInstance();

        Assertions.assertSame(instance1, instance);
    }
}
