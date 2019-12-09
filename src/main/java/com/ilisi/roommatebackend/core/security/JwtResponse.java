package com.ilisi.roommatebackend.core.security;

import com.ilisi.roommatebackend.model.User;
import lombok.Getter;
import lombok.Setter;

public class JwtResponse {

    @Getter @Setter
    String token;

    @Getter @Setter
    User user;

    public JwtResponse(String token, User user){
        this.token=token;
        this.user=user;
    }
}
