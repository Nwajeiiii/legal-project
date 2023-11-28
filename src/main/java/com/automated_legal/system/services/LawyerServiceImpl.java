package com.automated_legal.system.services;

import com.automated_legal.system.entities.Lawyer;
import com.automated_legal.system.models.LawyerResponse;
import com.automated_legal.system.repositories.LawyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LawyerServiceImpl implements LawyerService{

    private final LawyerRepository lawyerRepository;

    @Override
    public List<LawyerResponse> findLawyers(String keyword) {
        List<Lawyer> lawyers = this.lawyerRepository.findByLawyerFullNameContainingIgnoreCase(keyword);
        List<LawyerResponse> lawyerResponses = new ArrayList<>();

        lawyers.forEach(lawyer -> {
            LawyerResponse response = new LawyerResponse();
            response.setLawyerName(lawyer.getFullName());
            response.setBiography(lawyer.getBiography());
            response.setYearsOfExperience(lawyer.getYearsOfExperience().toString());
            response.setPracticeArea(lawyer.getPracticeArea());
            response.setEmail(lawyer.getEmail());
            lawyerResponses.add(response);
        });

        return lawyerResponses;
    }
}
