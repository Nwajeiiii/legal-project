package com.automated_legal.system.services;

import com.automated_legal.system.models.LoginRequest;
import com.automated_legal.system.models.LoginResponse;
import com.automated_legal.system.models.SignupRequest;
import com.automated_legal.system.models.SignupResponse;

import java.text.ParseException;

public interface UserService {

    SignupResponse registerUser (SignupRequest request);

    LoginResponse loginUser (LoginRequest request);

}
