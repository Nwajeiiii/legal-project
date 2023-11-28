package com.automated_legal.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "lawyer_consultation")
@Getter
@Setter
@ToString
public class LawyerConsultation {

    @Id
    @Column(name = "lawyer_consultation_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "lawyer_id", referencedColumnName = "lawyer_id", nullable = false)
    private Lawyer lawyerId;

    @Column(name = "message", nullable = false)
    private String message;

}
