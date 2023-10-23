package com.send.email.controller;

import com.send.email.model.User;
import com.send.email.repository.UserRepository;
import com.send.email.response.UserResponseDTO;
import com.send.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository usuarioRepository;
    @Autowired
    UserService userservice;

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastraUsuario(@RequestBody @Valid UserRequest userRequest) {
        User user = userRequest.toModel();
        usuarioRepository.save(user);
        return ResponseEntity.ok().build();
    }
    //Adicionar o responde para o método getmapping por id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public void sendUserMessage(@RequestParam Long userId) {
        userservice.sendMessage(userId);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = usuarioRepository.findAll();
        List<UserResponseDTO> userDTOs = users.stream()
                .map(user -> new UserResponseDTO(user.getEmail(), user.getPassword()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOs);
    }
}