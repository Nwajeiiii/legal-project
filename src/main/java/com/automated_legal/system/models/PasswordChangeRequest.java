package com.automated_legal.system.models;

import lombok.Data;

@Data
public class PasswordChangeRequest {

    private String email;
    private String password;

}
