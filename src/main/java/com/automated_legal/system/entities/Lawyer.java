package com.automated_legal.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "lawyers")
@Getter
@Setter
@ToString
public class Lawyer {

    @Id
    @Column(name = "lawyer_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lawyer_full_name", nullable = false)
    private String fullName;

    @Column(name = "lawyer_email", nullable = false, unique = true)
    private String email;

    @Column(name = "lawyer_biography", nullable = false)
    private String biography;

    @Column(name = "years_of_experience", nullable = false)
    private Short yearsOfExperience;

    @Column(name = "practice_area", nullable = false)
    private String practiceArea;
}
