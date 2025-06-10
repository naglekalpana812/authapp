package org.kalpana.projects.authservice.repository;

import org.kalpana.projects.authservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}