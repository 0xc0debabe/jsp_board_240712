package com.hmw.jsp.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8.
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8"); // 완성되는 HTML 인코딩을 UTF-8로 하겠다.
        resp.setContentType("text/html; charset utf-8"); // 브라우저에게 우리 결과물을 UTF-8로 하겠다.
    }

    public int getIntParam(String paramName, int defaultValue) {
        String value = req.getParameter(paramName);
//        req.getParameter는 요청으로부터 값을 받아옴(주소창에www.google.com/asdf?param=3) 이런거(아마)

        if (value == null) {
//            value가 null일 경우 디폴트 리턴(int로 리턴)
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
//            value를 Int로 반환하는데 www.google.com/asdf?param=3에서 param=32ab로 올 수도 있음
        } catch (NumberFormatException e) {
//            그것을 numberFormatException을 통해서 예외처리
            return defaultValue;
        }
    }

    public void appendBody(String str) {
//        응답으로부터 getWriter

        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getParam(String paramName, String defaultValue) {
//        요청으로부터 겟파라미터해서 저장
        String value = req.getParameter(paramName);

//        value == null일때 디폴트 www.google.com/asdf 로 입력하면 디폴트인듯
        if (value == null) {
            return defaultValue;
        }

        return value;
    }

    public void setAttr(String name, Object value) {
        req.setAttribute(name, value);
    }

    public void view(String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");

        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
