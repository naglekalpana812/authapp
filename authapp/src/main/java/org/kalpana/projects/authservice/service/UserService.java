package org.kalpana.projects.authservice.service;

import org.kalpana.projects.authservice.dto.LoginRequest;
import org.kalpana.projects.authservice.dto.MessageResponse;
import org.kalpana.projects.authservice.dto.RegisterRequest;
import org.kalpana.projects.authservice.entity.User;
import org.kalpana.projects.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MessageResponse registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return new MessageResponse("Username already exists.");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return new MessageResponse("User registered successfully.");
    }

    public MessageResponse loginUser(LoginRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            return new MessageResponse("Login successful.");
        }
        return new MessageResponse("Invalid credentials.");
    }

    public MessageResponse logoutUser() {
        // For session-based or JWT invalidation logic
        return new MessageResponse("Logout successful (handled on client/JWT).");
    }
}
