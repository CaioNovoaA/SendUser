package com.send.email.controller;

import com.send.email.model.EnviaHash;
import com.send.email.repository.EnviaHashRepository;
import com.send.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/send")
public class EnviaHashController {
    @Autowired
    UserService userService;
    @Autowired
    private EnviaHashRepository enviaHashRepository;

    @Autowired
    public EnviaHashController(EnviaHashRepository enviaHashRepository) {
        this.enviaHashRepository = enviaHashRepository;
    }

    @PostMapping
    public void sendUserMessage(@RequestParam Long userId) {
        userService.sendMessage(userId);
    }

}
