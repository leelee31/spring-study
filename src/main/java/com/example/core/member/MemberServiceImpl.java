package com.example.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository mr;

    /*
    MemberServiceImpl은 이제 의존 관계에 대한 고민은 외부에 책임을 넘기고 실행에만 집중하면 된다
    = 관심사의 분리
     */
    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
        this.mr = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        mr.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return mr.findById(memberId);
    }
}
