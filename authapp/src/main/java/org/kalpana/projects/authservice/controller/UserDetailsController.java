package org.kalpana.projects.authservice.controller;

import jakarta.validation.Valid;
import org.kalpana.projects.authservice.entity.UserDetails;
import org.kalpana.projects.authservice.service.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public UserDetails createUser(@Valid @RequestBody UserDetails userDetails) {
        return userDetailsService.saveUserDetails(userDetails);
    }
}