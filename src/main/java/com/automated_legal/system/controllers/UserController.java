package com.automated_legal.system.controllers;

import com.automated_legal.system.models.LoginRequest;
import com.automated_legal.system.models.LoginResponse;
import com.automated_legal.system.models.SignupRequest;
import com.automated_legal.system.models.SignupResponse;
import com.automated_legal.system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @PostMapping("/register")
    public SignupResponse registerUser (@RequestBody SignupRequest request) {
        return this.userService.registerUser(request);
    }

    @CrossOrigin
    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest loginRequest) {
        return this.userService.loginUser(loginRequest);
    }

}
