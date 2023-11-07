package com.producer.send.response;

public class UserResponseDTO {

    private Long id;
    private String email;
    private String password;

    public UserResponseDTO(String email, String password,Long id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
