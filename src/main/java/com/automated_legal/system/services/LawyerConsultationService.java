package com.automated_legal.system.services;

import com.automated_legal.system.models.LawyerConsultationRequest;
import com.automated_legal.system.models.LawyerConsultationResponse;

public interface LawyerConsultationService {

    LawyerConsultationResponse saveConsultation(LawyerConsultationRequest request);
}
