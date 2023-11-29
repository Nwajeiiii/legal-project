package com.automated_legal.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "forums")
@Getter
@Setter
@ToString
public class Forum {

    @Id
    @Column(name = "forum_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "forum_title", nullable = false)
    private String title;

    @Column(name = "forum_content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User userId;

}
