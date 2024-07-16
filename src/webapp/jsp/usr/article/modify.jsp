<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hmw.jsp.board.article.ArticleDto"%>

<%
ArticleDto article = (ArticleDto) request.getAttribute("article");
%>



<h1>게시물 수정</h1>

<script>
    function ArticleSave__submitForm(form) {
        form.title.value = form.title.value.trim();

        if(form.title.value.length == 0) {
            alert('제목을 입력해주세요.');
            form.title.focus();
            return;
        }

        form.body.value = form.body.value.trim();
        if (form.body.value.length == 0) {
            alert('내용을 입력해주세요.');
            form.body.focus();
            return;
        }

        form.submit();
    }
</script>

<form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." value="<%=article.getTitle()%>">
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <textarea name="body" cols="30" rows="10" placeholder="내용을 입력해주세요."><%=article.getBody()%></textarea>
        </div>
    </div>

    <div style="display:flex; gap: 0 5px; margin-top: 5px">
        <button type="submit">수정</button>
        <a href="/usr/article/list">취소</a>
    </div>

</form>