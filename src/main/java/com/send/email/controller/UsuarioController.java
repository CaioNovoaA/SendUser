package com.send.email.controller;

import com.send.email.model.UserTb;
import com.send.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    UserRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UserTb> cadastraUsuario(@RequestBody @Valid UserRequest userRequest){
        UserTb user = userRequest.toModel();
        usuarioRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
