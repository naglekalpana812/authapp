package org.kalpana.projects.authservice.repository;

import org.kalpana.projects.authservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
