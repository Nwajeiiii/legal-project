package com.automated_legal.system.services;

import com.automated_legal.system.entities.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findArticles(String keyword);

}
