package com.ilisi.roommatebackend;

import com.ilisi.roommatebackend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = {"com.ilisi.roommatebackend.repository"})
@SpringBootApplication
public class RoommateBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoommateBackendApplication.class, args);
    }

}
