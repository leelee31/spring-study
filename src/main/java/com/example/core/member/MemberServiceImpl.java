package com.example.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    /*
    MemberServiceImpl은 이제 의존 관계에 대한 고민은 외부에 책임을 넘기고 실행에만 집중하면 된다
    = 관심사의 분리
     */
    @Autowired
    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
        this.memberRepository = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // @Configuration @Bean에서 memberRepository 중복 호출 시 중복 생성되나 test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
