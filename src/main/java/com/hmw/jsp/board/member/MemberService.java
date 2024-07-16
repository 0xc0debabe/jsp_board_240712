package com.hmw.jsp.board.member;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }
}
