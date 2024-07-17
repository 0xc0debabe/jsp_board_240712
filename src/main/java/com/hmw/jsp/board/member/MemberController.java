package com.hmw.jsp.board.member;

import com.hmw.jsp.board.Rq;

public class MemberController {
    private MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }


    public void showLogin(Rq rq) {
        rq.print("로그인");
    }
}
