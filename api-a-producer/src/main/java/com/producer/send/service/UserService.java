package com.producer.send.service;

import com.producer.send.model.User;
import com.producer.send.rabbitmq.RabbitMQConfig;
import com.producer.send.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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