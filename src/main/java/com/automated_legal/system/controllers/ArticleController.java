package com.automated_legal.system.controllers;

import com.automated_legal.system.entities.Article;
import com.automated_legal.system.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @CrossOrigin
    @GetMapping("/{keyword}")
    public List<Article> findArticles(@PathVariable(name = "keyword") String keyword){
        return this.articleService.findArticles(keyword);
    }

}
