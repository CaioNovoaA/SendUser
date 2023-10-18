package com.send.email.controller;

import com.send.email.model.EnviaHash;
import com.send.email.repository.EnviaHashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EnviaHashController {

    @Autowired
    private EnviaHashRepository enviaHashRepository;

    @Autowired
    public EnviaHashController(EnviaHashRepository enviaHashRepository) {
        this.enviaHashRepository = enviaHashRepository;
    }

    @PostMapping("/enviaHash")
    public ResponseEntity<EnviaHash> Enviahash(@RequestBody @Valid EnviaHash enviaHash) {
        enviaHashRepository.save(enviaHash);

        return ResponseEntity.ok().build();
    }

}
