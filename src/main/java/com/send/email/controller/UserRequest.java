package com.send.email.controller;

import com.send.email.model.UserTb;

public class UserRequest {
    private String email;
    private String senha;

    public UserRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UserTb toModel() {
        return new UserTb(email, senha);

    }
}
