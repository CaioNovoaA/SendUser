package com.producer.send.repository;

import com.producer.send.model.EnviaHash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnviaHashRepository extends JpaRepository<EnviaHash, Long> {
}
