package org.online.queue.onlinequeuesecurity.repository;

import org.online.queue.onlinequeuesecurity.model.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    Optional<Credentials> findByEmail(String username);
}