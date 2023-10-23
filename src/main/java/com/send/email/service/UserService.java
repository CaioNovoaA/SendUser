package com.send.email.service;

import com.send.email.controller.UserRequest;
import com.send.email.model.User;
import com.send.email.rabbitmq.RabbitMQConfig;
import com.send.email.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserRepository userRepository;

    public void sendMessage(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "user.created", user);
    }
}