package com.producer.send.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.producer.send.model.User;
import com.producer.send.rabbitmq.RabbitMQConfig;
import com.producer.send.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;



    @MockBean
    private RabbitTemplate rabbitTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testSendMessage() {
        // Dados de teste
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        // Configuração do mock
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Execução do teste
        userService.sendMessage(userId);

        // Verificação
        verify(rabbitTemplate).convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "user.created", user);
    }



    @Test
    void testSendMessageWithNullUserId() {
        // Dados de teste
        Long userId = null;

        // Execução do teste e verificação
        assertThrows(IllegalArgumentException.class, () -> userService.sendMessage(userId));
    }
}





