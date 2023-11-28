package com.automated_legal.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 24, unique = true)
    private String fullName;

    @Column(name = "user_email", nullable = false, length = 24, unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

}
