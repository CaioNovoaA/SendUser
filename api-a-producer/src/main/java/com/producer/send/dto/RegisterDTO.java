package com.producer.send.dto;

import javax.validation.constraints.NotBlank;


public record RegisterDTO(
        @NotBlank(message = "Não deveria ser nulo")
        String login, String password,
        @NotBlank(message = "Não deveria ser nulo")
        String role
) {

}
