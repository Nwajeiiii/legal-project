package com.automated_legal.system.services;

import com.automated_legal.system.entities.Article;
import com.automated_legal.system.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;


    @Override
    public List<Article> findArticles(String keyword) {
        return this.articleRepository.findByArticleNameContainingIgnoreCase(keyword);
    }
}
