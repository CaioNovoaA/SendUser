package com.producer.send.controller;

import com.producer.send.repository.UserRepository;
import com.producer.send.model.User;
import com.producer.send.response.UserResponseDTO;
import com.producer.send.service.RabbitMQService;
import com.producer.send.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    RabbitMQService rabbitMQService;

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastraUsuario(@RequestBody @Valid UserRequest userRequest) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(userRequest.getPassword());
        User user = new User(userRequest.getLogin(),encryptedPassword, userRequest.getRole());
        usuarioRepository.save(user);
        return ResponseEntity.ok().build();
    }
    //Adicionar o responde para o método getmapping por id
    @GetMapping("/take/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public void sendUserMessage(@RequestParam Long userId) {
        rabbitMQService.sendMessage(userId);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = usuarioRepository.findAll();
        List<UserResponseDTO> userDTOs = users.stream()
                .map(user -> new UserResponseDTO(user.getLogin(), user.getPassword(), user.getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOs);
    }
}