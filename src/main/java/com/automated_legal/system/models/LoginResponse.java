package com.automated_legal.system.models;

import lombok.Data;

@Data
public class LoginResponse {

    private String responseCode;
    private String responseMessage;
    private String  fullName;
    private String email;
    private String password;
}
