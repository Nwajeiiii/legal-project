package com.automated_legal.system.repositories;

import com.automated_legal.system.entities.Article;
import com.automated_legal.system.entities.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    @Query("SELECT l FROM Lawyer l WHERE " +
            "LOWER(l.fullName) LIKE LOWER(CONCAT('% ', :searchTerm, ' %')) OR " +
            "LOWER(l.fullName) LIKE LOWER(CONCAT(:searchTerm, ' %')) OR " +
            "LOWER(l.fullName) LIKE LOWER(CONCAT('% ', :searchTerm)) OR " +
            "LOWER(l.fullName) = LOWER(:searchTerm)")
    List<Lawyer> findByLawyerFullNameContainingIgnoreCase(String searchTerm);

    Lawyer findByEmail(String email);


}
