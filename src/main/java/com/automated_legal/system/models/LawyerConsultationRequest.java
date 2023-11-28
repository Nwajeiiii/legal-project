package com.automated_legal.system.models;

import lombok.Data;

@Data
public class LawyerConsultationRequest {

    private String userEmail;
    private String lawyerEmail;
    private String message;

}
