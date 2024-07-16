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

        switch (rq.getMethod()) {
            case "GET" -> {
                switch (rq.getActionPath()) {
                    case "/usr/article/list" -> articleController.showList(rq);
                    case "/usr/article/detail" -> articleController.showDetail(rq);
                    case "/usr/article/write" -> articleController.showWrite(rq);
                    case "/usr/article/modify" -> articleController.showModify(rq);
                    case "/usr/article/delete" -> articleController.doDelete(rq);
                    case "/usr/member/login" -> memberController.showLogin(rq);
                }
            }

            case "POST" -> {
                switch (rq.getActionPath()) {
                    case "/usr/article/write" -> articleController.doWrite(rq);
                    case "/usr/article/modify" -> articleController.doModify(rq);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
