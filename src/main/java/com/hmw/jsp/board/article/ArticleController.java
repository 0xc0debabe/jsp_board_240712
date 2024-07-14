package com.hmw.jsp.board.article;

import com.hmw.jsp.board.Rq;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq) {
        rq.appendBody("게시글");
        List<ArticleDto> articleDtos = new ArrayList<>();

        for (int i = 5; i >= 1; i--) {
            articleDtos.add(new ArticleDto(i, "제목" + i, "내용" + i));
        }

        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");
    }
}
