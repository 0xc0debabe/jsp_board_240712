<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<%@ include file="../common/head.jspf" %>

<section class="article-write-wrap mt-[10px]">
    <div class="container mx-auto">
        <form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
            <div>
                <span>제목</span>
                <div>
                    <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요.">
                </div>
            </div>

            <div>
                <span>내용</span>
                <div>
                    <textarea name="body" cols="30" rows="10" placeholder="내용을 입력해주세요."></textarea>
                </div>
            </div>

            <div class="flex gap-x-[5px] mt-[5px]">
                <button type="submit">작성</button>
                <a href="/usr/article/list">취소</a>
            </div>

        </form>
    </div>
</section>
<%@ include file="../common/foot.jspf" %>
