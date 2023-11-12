package com.automated_legal.system.models;

import lombok.Data;

@Data
public class SignupRequest {

    private String fullName;
    private String email;
    private String password;
}
