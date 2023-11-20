package com.automated_legal.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "articles")
@Getter
@Setter
@ToString
public class Article {

    @Id
    @Column(name = "article_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="article_name", nullable = false)
    private String name;

    @Column(name="article_link", nullable = false)
    private String link;

}
