package com.hmw.jsp.board.article;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }
    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }


    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public void delete(long id) {
        articleRepository.delete(id);
    }

    public void modify(long id, String title, String body) {
        articleRepository.modify(id, title, body);
    }
}
