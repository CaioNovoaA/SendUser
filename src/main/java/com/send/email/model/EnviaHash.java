package com.send.email.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnviaHash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hash;

    @Deprecated
    public EnviaHash() {
    }

    public EnviaHash(Long id, String hash) {
        this.id = id;
        this.hash = hash;
    }
}