package org.kalpana.projects.authservice.service;

import jakarta.transaction.Transactional;
import org.kalpana.projects.authservice.entity.UserDetails;
import org.kalpana.projects.authservice.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    private final UserDetailsRepository  userDetailsRepository;

    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Transactional
    public UserDetails saveUserDetails(UserDetails userDetails) {
        if (userDetails.getContacts() != null) {
            userDetails.getContacts().forEach(contact -> contact.setUserDetails(userDetails));
        }
        if (userDetails.getAddresses() != null) {
            userDetails.getAddresses().forEach(address -> address.setUserDetails(userDetails));
        }
        return userDetailsRepository.save(userDetails);
    }
}
