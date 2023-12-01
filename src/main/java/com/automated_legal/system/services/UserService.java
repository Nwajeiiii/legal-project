package com.automated_legal.system.services;

import com.automated_legal.system.models.*;

import java.text.ParseException;

public interface UserService {

    SignupResponse registerUser (SignupRequest request);

    LoginResponse loginUser (LoginRequest request);

    PasswordChangeResponse changeUserPassword(PasswordChangeRequest request);

}
