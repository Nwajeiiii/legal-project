package com.automated_legal.system.services;

import com.automated_legal.system.entities.User;
import com.automated_legal.system.models.*;
import com.automated_legal.system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public SignupResponse registerUser(SignupRequest request) {
        SignupResponse response = new SignupResponse();
        User user = new User();

        if (request.getFullName() == null || request.getPassword() == null || request.getEmail() == null) {
            response.setResponseCode("999");
            response.setResponseMessage("make sure no field is null");
            return response;
        }


        boolean containsAtSymbol = request.getEmail().chars().anyMatch(ch -> ch == '@');
        if (!containsAtSymbol) {
            response.setResponseCode("999");
            response.setResponseMessage("enter a valid email address");
            return response;
        }

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            response.setResponseCode("999");
            response.setResponseMessage(e.getMessage());
            return response;
        }

        response.setResponseCode("000");
        response.setResponseMessage("user successfully registered");
        return response;

    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        User user = this.userRepository.findByEmail(request.getEmail());

        if (user == null) {
            response.setResponseCode("999");
            response.setResponseMessage("no such user exists");
            return response;
        }

        if (!user.getPassword().equals(request.getPassword())) {
            response.setResponseCode("999");
            response.setResponseMessage("incorrect password");
            return response;
        }

        response.setResponseCode("000");
        response.setResponseMessage("user successfully logged in");
        response.setPassword(user.getPassword());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        return response;
    }

    @Override
    public PasswordChangeResponse changeUserPassword(PasswordChangeRequest request) {
        PasswordChangeResponse response = new PasswordChangeResponse();
        User user = this.userRepository.findByEmail(request.getEmail());

        if (user == null){
            response.setResponseCode("999");
            response.setResponseMessage("000");
            return response;
        }

        user.setPassword(request.getPassword());

        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            response.setResponseCode("999");
            response.setResponseMessage(e.getMessage());
            return response;
        }

        response.setResponseCode("000");
        response.setResponseMessage("successful");
        return response;

    }


}
