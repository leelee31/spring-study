package com.example.core;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.order.OrderService;
import com.example.core.order.OrderServiceImpl;

/*
* DI 해주는 역할, 캐스팅 담당자
*/
public class AppConfig {
    public MemberService memberService () {
        return new MemberServiceImpl(getMemoryMemberRepository());
    }

    private MemoryMemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService () {
        return new OrderServiceImpl(getMemoryMemberRepository(), getDiscountPolicy());
    }

    private DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
