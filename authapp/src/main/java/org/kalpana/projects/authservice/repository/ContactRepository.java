package org.kalpana.projects.authservice.repository;

import org.kalpana.projects.authservice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
