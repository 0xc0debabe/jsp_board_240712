<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hmw.jsp.board.article.ArticleDto"%>

<%
    ArticleDto article = (ArticleDto) request.getAttribute("article");
%>

    <h1>게시물 상세보기</h1>
    <div>
        <% if (article != null) { %>
            <div>
                ID : <%=article.getId()%>
            </div>

            <div>
                제목 : <%=article.getTitle()%>
            </div>

            <div>
                내용 : <%=article.getBody()%>
             </div>
        <% } %>

    </div>