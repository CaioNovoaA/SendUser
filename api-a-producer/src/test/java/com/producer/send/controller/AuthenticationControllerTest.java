package com.producer.send.controller;

import com.producer.send.dto.AuthenticationDTO;
import com.producer.send.model.User;
import com.producer.send.repository.UserRepository;
import com.producer.send.response.LoginResponseDTO;
import com.producer.send.security.TokenService;
import com.producer.send.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @Mock
    UserService userService;

    @InjectMocks
    private AuthenticationController authenticationController;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Authentication auth = new UsernamePasswordAuthenticationToken("user", "password");
        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("user", "password"))).thenReturn(auth);
        when(tokenService.generateToken((User) auth.getPrincipal())).thenReturn("token");
    }


}



