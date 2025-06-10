package org.kalpana.projects.authservice.service;

import lombok.extern.slf4j.Slf4j;
import org.kalpana.projects.authservice.dto.LoginRequest;
import org.kalpana.projects.authservice.dto.MessageResponse;
import org.kalpana.projects.authservice.dto.RegisterRequest;
import org.kalpana.projects.authservice.entity.User;
import org.kalpana.projects.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.kalpana.projects.authservice.service.Constants.*;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MessageResponse registerUser(RegisterRequest request) {
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            return createMessageResponse(existingUser, USER_EXISTS);
        }
        return createMessageResponse(saveUser(request), USER_CREATED);
    }

    private User saveUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    private MessageResponse createMessageResponse(User user, String message) {
        MessageResponse messageResponse = new MessageResponse(message);
        messageResponse.setUserId(user.getId());
        messageResponse.setName(user.getUsername());
       log.debug("messageResponse created {}", messageResponse);
        return messageResponse;
    }

    public MessageResponse loginUser(LoginRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
           createMessageResponse(user.get(), LOGGED_IN);
        }
        return new MessageResponse("Invalid credentials.");
    }

    public MessageResponse logoutUser() {
        // For session-based or JWT invalidation logic
        return new MessageResponse("Logout successful (handled on client/JWT).");
    }
}
