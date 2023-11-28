package com.automated_legal.system.services;

import com.automated_legal.system.entities.Lawyer;
import com.automated_legal.system.entities.LawyerConsultation;
import com.automated_legal.system.entities.User;
import com.automated_legal.system.models.LawyerConsultationRequest;
import com.automated_legal.system.models.LawyerConsultationResponse;
import com.automated_legal.system.repositories.LawyerConsultationRepository;
import com.automated_legal.system.repositories.LawyerRepository;
import com.automated_legal.system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LawyerConsultationServiceImpl implements LawyerConsultationService{

    private final UserRepository userRepository;
    private final LawyerRepository lawyerRepository;
    private final LawyerConsultationRepository lawyerConsultationRepository;

    @Override
    public LawyerConsultationResponse saveConsultation(LawyerConsultationRequest request) {
        LawyerConsultationResponse response = new LawyerConsultationResponse();

        LawyerConsultation lawyerConsultation = new LawyerConsultation();

        User user = this.userRepository.findByEmail(request.getUserEmail());
        Lawyer lawyer = this.lawyerRepository.findByEmail(request.getLawyerEmail());

        try {
            lawyerConsultation.setLawyerId(lawyer);
            lawyerConsultation.setUserId(user);
            lawyerConsultation.setMessage(request.getMessage());
            this.lawyerConsultationRepository.save(lawyerConsultation);
        } catch (Exception e) {
            response.setResponseCode("999");
            response.setResponseMessage(e.getLocalizedMessage());
            return response;
        }

        response.setResponseCode("000");
        response.setResponseMessage("Successfully saved consultation");
        return response;
    }
}
