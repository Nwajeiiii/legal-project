package com.automated_legal.system.controllers;

import com.automated_legal.system.models.LawyerConsultationRequest;
import com.automated_legal.system.models.LawyerConsultationResponse;
import com.automated_legal.system.services.LawyerConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultations")
public class LawyerConsultationController {

    private final LawyerConsultationService lawyerConsultationService;

    @PostMapping
    @CrossOrigin
    LawyerConsultationResponse saveConsultation(@RequestBody LawyerConsultationRequest lawyerConsultationRequest){
        return this.lawyerConsultationService.saveConsultation(lawyerConsultationRequest);
    }

}
