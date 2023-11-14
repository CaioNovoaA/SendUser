package com.producer.send.controller;

import com.producer.send.model.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
public class UserRequest {

    @NotNull
    @NotBlank
    @Email(message = "Email must be a valid email address")
    private String login;
    @NotNull
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private String role;

    public UserRequest(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setEmail(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toModel() {
        return new User(login, password);
    }


}