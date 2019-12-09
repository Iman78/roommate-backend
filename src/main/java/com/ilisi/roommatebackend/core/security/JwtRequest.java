package com.ilisi.roommatebackend.core.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class JwtRequest {

    @NotNull(message = "login.username-is-missing")
    @Getter @Setter
    private String username;

    @NotNull(message = "login.password-is-missing")
    @Getter @Setter
    private String password;

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
