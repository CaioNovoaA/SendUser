package com.send.email.dto;

import com.send.email.enumerador.UserRole;

public record RegisterDTO(String login, String password, String role) {
}
