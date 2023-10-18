package com.send.email.repository;

import com.send.email.model.EnviaHash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnviaHashRepository extends JpaRepository<EnviaHash, Long> {
}
