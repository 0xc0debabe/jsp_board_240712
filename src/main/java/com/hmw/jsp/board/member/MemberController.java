package com.hmw.jsp.board.member;

import com.hmw.jsp.board.Rq;

public class MemberController {
    public void showLogin(Rq rq) {
        rq.appendBody("로그인");
    }
}
