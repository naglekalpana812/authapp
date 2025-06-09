package org.kalpana.projects.authservice.controller;

import org.kalpana.projects.authservice.dto.LoginRequest;
import org.kalpana.projects.authservice.dto.MessageResponse;
import org.kalpana.projects.authservice.dto.RegisterRequest;
import org.kalpana.projects.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public MessageResponse register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public MessageResponse login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }

    @PostMapping("/logout")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public MessageResponse logout() {
        return userService.logoutUser();
    }
}
