package com.automated_legal.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@ToString
public class Review {

    @Id
    @Column(name = "review_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lawyer_id", referencedColumnName = "lawyer_id", nullable = false)
    private Lawyer lawyer;

    @Column(name = "rating", nullable = false)
    private Byte rating;

    @Column(name = "review", nullable = false)
    private String review;


}
