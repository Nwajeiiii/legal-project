package com.automated_legal.system.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "legal_documents")
@Getter
@Setter
@ToString
public class LegalDocument {

    @Id
    @Column(name = "legal_doc_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "legal_doc_name", nullable = false)
    private String name;

    @Column(name = "legal_doc_link", nullable = false)
    private String link;

}
