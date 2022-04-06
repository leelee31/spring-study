package com.example.core;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.order.OrderService;
import com.example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* DI 해주는 역할, 캐스팅 담당자
* @configuration을 붙이면 @bean들이 스프링 컨테이너에 등록됨
*/

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(getMemoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService () {
        return new OrderServiceImpl(getMemoryMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
