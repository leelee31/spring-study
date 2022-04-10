package com.example.core.singleton;

import com.example.core.AppConfig;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberServiceImpl;
import com.example.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    
    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("getMemoryMemberRepository", MemberRepository.class);

        // 모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository" + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository" + orderService.getMemberRepository());
        System.out.println("memberRepository" + memberRepository);

        Assertions.assertSame(memberRepository, memberService.getMemberRepository());
        Assertions.assertSame(memberRepository, orderService.getMemberRepository());
    }
}
