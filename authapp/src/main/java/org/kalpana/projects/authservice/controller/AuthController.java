package org.kalpana.projects.authservice.controller;

import org.kalpana.projects.authservice.dto.LoginRequest;
import org.kalpana.projects.authservice.dto.MessageResponse;
import org.kalpana.projects.authservice.dto.RegisterRequest;
import org.kalpana.projects.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public MessageResponse register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public MessageResponse login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }

    @PostMapping("/logout")
    public MessageResponse logout() {
        return userService.logoutUser();
    }
}
