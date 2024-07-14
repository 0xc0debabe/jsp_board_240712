<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hmw.jsp.board.article.ArticleDto"%>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

    <h1>게시물 리스트</h1>
    <ul>
        <% for(ArticleDto article : articles) { %>
            <li><%=article.getId()%>번 : <%=article.getTitle()%></li>
        <% } %>
    </ul>