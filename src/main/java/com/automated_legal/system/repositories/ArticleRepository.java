package com.automated_legal.system.repositories;

import com.automated_legal.system.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Article> findByArticleNameContainingIgnoreCase(String searchTerm);

}
