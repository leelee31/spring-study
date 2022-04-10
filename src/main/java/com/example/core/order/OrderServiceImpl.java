package com.example.core.order;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//    private final DiscountPolicy dp = new FixDiscountPolicy();
//    private final DiscountPolicy dp = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;
/*
생성자 주입
 */
    public OrderServiceImpl(MemoryMemberRepository memoryMemberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memoryMemberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // @Configuration @Bean에서 memberRepository 중복 호출 시 중복 생성되나 test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
