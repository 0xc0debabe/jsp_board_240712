package com.hmw.jsp.board.servlet;

import com.hmw.jsp.board.Rq;
import com.hmw.jsp.board.article.ArticleController;
import com.hmw.jsp.board.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        String url = req.getRequestURI();

        switch (url) {
            case "/usr/article/list" -> articleController.showList(rq);
            case "/usr/member/login" -> memberController.showLogin(rq);

        }
    }
}
