package com.hmw.jsp.board.servlet;


import com.hmw.jsp.board.Rq;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        int dan = rq.getIntParam("dan", 9);
        int limit = rq.getIntParam("limit", 9);

        rq.writer("<h1>===%d===</h1>".formatted(dan));
        for (int i = 1; i <= limit; i++) {
            rq.writer("<div>%d * %d = %d</div>".formatted(i, i, dan * i));
        }

    }
}
