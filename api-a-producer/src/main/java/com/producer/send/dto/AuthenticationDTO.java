package com.producer.send.dto;

import javax.validation.constraints.NotBlank;

public record AuthenticationDTO(@NotBlank(message = "Não deveria ser nulo") String login,@NotBlank(message = "Não deveria ser nulo") String password) {
}
