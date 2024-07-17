<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.hmw.jsp.board.article.ArticleDto"%>

<%
    ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<%@ include file="../common/head.jspf" %>

<section class="article-detail-wrap">
    <div class="container mx-auto">
        <div>
            <% if (article != null) { %>
            <div>
                ID : ${article.id}
            </div>

            <div>
                제목 : ${article.title}
            </div>

            <div>
                내용 : ${article.body}
            </div>
            <% } %>
            <div class="flex gap-x-[5px] mt-[5px]">
                <a href="/usr/article/list">리스트로 이동</a>
            </div>
        </div>
    </div>
</section>
<%@ include file="../common/foot.jspf" %>