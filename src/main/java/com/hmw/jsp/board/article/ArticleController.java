package com.hmw.jsp.board.article;

import com.hmw.jsp.board.Rq;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = articleService.findAll();

        if (articleDtos.isEmpty()) {
            rq.print("게시물이 존재하지않습니다.");
            return;
        }

        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("/usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");

        if (title.trim().isEmpty()) {
            System.out.println("제목을 입력해주세요.");
            return;
        }

        String body = rq.getParam("body", "");
        if (body.trim().isEmpty()) {
            System.out.println("내용을 입력해주세요");
            return;
        }

        long id = articleService.write(title, body);

        rq.print("<div>%d번 게시물이 생성되었습니다.</div>".formatted(id));
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.print("올바른 요청이 아닙니다.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.print("게시물이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("/usr/article/detail");
    }

    public void doDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.print("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);
        if (articleDto == null) {
            rq.print("해당 게시물이 존재하지 않습니다.");
            return;
        }

        articleService.delete(id);
        rq.print("%d번 게시물이 삭제되었습니다.".formatted(id));
        rq.print("<div><a href=\"/usr/article/list/free\">리스트로 이동</a></div>");
    }

    public void showModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        if (id == 0) {
            rq.print("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.print("해당 게시물이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("/usr/article/modify");
    }

    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        articleService.modify(id, title, body);
        rq.print("%d번 게시물이 수정되었습니다.".formatted(id));
        rq.print("""
                <div>
                 <a href="/usr/article/detail/free/%d">수정된 글로 이동</a>
                </div>
                """.formatted(id));
    }
}
