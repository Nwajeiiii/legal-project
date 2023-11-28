package com.automated_legal.system.repositories;

import com.automated_legal.system.entities.LawyerConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerConsultationRepository extends JpaRepository<LawyerConsultation, Long> {
}
