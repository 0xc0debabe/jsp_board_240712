<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hmw.jsp.board.article.ArticleDto"%>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

    <!-- 테일윈드 불러오기 -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!--  보통 구역은 섹션으로 나눈다  -->
    <section class="article-list-wrap">
<!--       container는 창크기가 커져도 글자 알아서줄여줌, mx-auto는 중앙정렬 -->
        <div class="container mx-auto">
<!--            font 굵게, 텍스트 크게-->
            <h1 class="font-bold text-lg ">게시물 리스트</h1>
<!--            마진 탑5(위와 거리 5)-->
            <ul class="mt-5">
                <% for(ArticleDto article : articles) { %>
<!--                li가 flex 컨테이너가 된다.-->
<!--                li가 flex가 되는 경우 그의 자식은 flex item이 된다-->
                <li class="flex">
                    <a  href="/usr/article/detail/free/<%=article.getId()%>" class="w-[40px] text-center hover:underline hover:text-[red]">
                        <%=article.getId()%>.
                    </a>
                    <a href="/usr/article/detail/free/<%=article.getId()%>" class="flex-grow hover:underline hover:text-[red]">
                        <%=article.getTitle()%>
                    </a>
                    <div class="flex gap-x-3">
                    <a onclick="if(!confirm('정말 삭제하시겠습니꾸아앙?')) return false;" href="/usr/article/delete/free/<%=article.getId()%>" class="flex-grow hover:underline hover:text-[red]">
                        삭제
                    </a>
                    <a href="/usr/article/modify/free/<%=article.getId()%>" class="flex-grow hover:underline hover:text-[red]">
                        수정
                    </a>
                    </div>
                </li>
                <% } %>
            </ul>
        </div>
    </section>

