package com.automated_legal.system.repositories;

import com.automated_legal.system.entities.LegalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LegalDocumentRepository extends JpaRepository<LegalDocument, Long> {

    @Query("SELECT ld FROM LegalDocument ld WHERE " +
            "LOWER(ld.name) LIKE LOWER(CONCAT('% ', :searchTerm, ' %')) OR " +
            "LOWER(ld.name) LIKE LOWER(CONCAT(:searchTerm, ' %')) OR " +
            "LOWER(ld.name) LIKE LOWER(CONCAT('% ', :searchTerm)) OR " +
            "LOWER(ld.name) = LOWER(:searchTerm)")
    List<LegalDocument> findByLegalDocNameContainingIgnoreCase(String searchTerm);

}
